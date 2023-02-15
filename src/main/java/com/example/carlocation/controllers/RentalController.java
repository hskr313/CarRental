package com.example.carlocation.controllers;

import com.example.carlocation.exceptions.HttpNotFoundException;
import com.example.carlocation.exceptions.HttpPreconditionFailedException;
import com.example.carlocation.models.dtos.rental.RentalDTO;
import com.example.carlocation.models.entities.Rental;
import com.example.carlocation.models.entities.Reservation;
import com.example.carlocation.models.forms.RentalAddForm;
import com.example.carlocation.models.forms.RentalReturnForm;
import com.example.carlocation.services.car.CarService;
import com.example.carlocation.services.rental.RentalService;
import com.example.carlocation.services.reservation.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping(path = "/rental")
public class RentalController implements BaseRestController<RentalDTO, Long> {

    private final RentalService rentalService;

    private final ReservationService reservationService;

    private final CarService carService;

    public RentalController(RentalService rentalService, ReservationService reservationService, CarService carService) {
        this.rentalService = rentalService;
        this.reservationService = reservationService;
        this.carService = carService;
    }

    @GetMapping(path = "/{id:[0_9]+}")
    public ResponseEntity<RentalDTO> readOne(@PathVariable Long id) {

        Rental rental = this.rentalService.readOneByKey(id).orElseThrow( () -> new HttpNotFoundException("Rental with id : " + id + "does not exist"));

        return ResponseEntity.ok(RentalDTO.toDTO(rental)) ;
    }

    @GetMapping(path = "")
    public ResponseEntity<Collection<RentalDTO>> readAll() {

        return ResponseEntity.ok(this.rentalService.readAll()
                .map(RentalDTO::toDTO)
                .toList());
    }

    @PostMapping(path = "")
    public ResponseEntity<RentalDTO> addOne(@Valid @RequestBody RentalAddForm form){
        Rental rental = form.toBLL();

        Reservation reservation = this.reservationService.readOneByKey(form.getReservationId()).orElseThrow( () -> new HttpNotFoundException("There is no reservation with id : " + form.getReservationId()));
        rental.setReservation(reservation);
        rental.setDeposit(this.carService.getIndicativePriceByPricingAndFormula(
                reservation.getCar().getId(),
                reservation.getCar().getModel().getPricingClass().getId(),
                reservation.getRentalFormula().getId()
                ) * 0.2 );

        if (!this.carService.isAvailable(reservation.getCar(), reservation.getRemoval(), reservation.getRestitution())){
            throw new HttpPreconditionFailedException("car is not available", new ArrayList<>());
        }

        try{
            this.rentalService.save(rental);
        } catch (Exception exception) {
            throw new HttpPreconditionFailedException("Form is not valid", new ArrayList<>());
        }

        return ResponseEntity.ok(RentalDTO.toDTO(rental));
    }

    @PatchMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<RentalDTO> updateReturn(@PathVariable Long id, @Valid @RequestBody RentalReturnForm form){
        Rental rental = this.rentalService.readOneByKey(id).orElseThrow(  () -> new HttpNotFoundException("Theres is no rental with id: " + id));

        rental.setReturnKm(form.getReturnKm());
        rental.setReturnDate(form.getReturnDate());

        try {
            this.rentalService.save(rental);
        } catch (Exception exception){
            throw  new HttpPreconditionFailedException("The modification of the lease has failed", new ArrayList<>());
        }

        return ResponseEntity.ok(RentalDTO.toDTO(rental));
    }


}

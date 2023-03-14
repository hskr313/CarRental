package com.example.carlocation.controllers;

import com.example.carlocation.exceptions.HttpNotFoundException;
import com.example.carlocation.exceptions.HttpPreconditionFailedException;
import com.example.carlocation.models.dtos.reservation.ReservationDTO;
import com.example.carlocation.models.entities.*;
import com.example.carlocation.models.forms.ReservationAddForm;
import com.example.carlocation.services.car.CarService;
import com.example.carlocation.services.customer.CustomerService;
import com.example.carlocation.services.rentalFormula.RentalFormulaService;
import com.example.carlocation.services.reservation.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = {"/reservation"})
public class ReservationController implements BaseRestController<ReservationDTO, Long> {

    private final ReservationService reservationService;

    private final CarService carService;

    private final RentalFormulaService formulaService;

    private final CustomerService customerService;

    public ReservationController(ReservationService reservationService, CarService carService, CustomerService customerService, RentalFormulaService formulaService) {
        this.reservationService = reservationService;
        this.carService = carService;
        this.formulaService = formulaService;
        this.customerService = customerService;
    }

    @Override
    @GetMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<ReservationDTO> readOne(@PathVariable Long id) {
        Reservation reservation = this.reservationService.readOneByKey(id).orElseThrow(() -> new HttpNotFoundException("Reservation with id :(" + id + ") does not exist"));
        ReservationDTO reservationDTO = ReservationDTO.toDTO(reservation);
        reservationDTO.setIndicativePrice(this.carService.getIndicativePriceByPricingAndFormula(
                reservation.getCar().getId(),
                reservation.getCar().getModel().getPricingClass().getId(),
                reservation.getRentalFormula().getId()
        ));
        return ResponseEntity.ok(reservationDTO);
    }

    @Override
    @GetMapping(path = "")
    public ResponseEntity<Collection<ReservationDTO>> readAll() {
        List<ReservationDTO> reservationDTOS = this.reservationService.readAll()
                .map(ReservationDTO::toDTO)
                .toList();

        return ResponseEntity.ok(reservationDTOS);
    }
    @PostMapping(path = "")
    public ResponseEntity<ReservationDTO> addReservation(@Valid @RequestBody ReservationAddForm form){
        Reservation reservation = form.toBLL();

        Car car = this.carService.readOneByKey(form.getIdCar()).orElseThrow(() -> new HttpNotFoundException("There is no car with id:(" + form.getIdCar()+ ")"));
        if (!this.carService.isAvailable(car,form.getRemoval(),form.getRestitution())){
            throw new HttpPreconditionFailedException("Car is not available", new ArrayList<>());
        }

        RentalFormula formula = this.formulaService.readOneByKey(form.getRentalFormulaId()).orElseThrow( () -> new HttpNotFoundException("There is no formula with id : " + form.getRentalFormulaId()));
        reservation.setRentalFormula(formula);

        Customer customer = this.customerService
                .readOneByKey(form.getIdCustomer())
                .orElse(this.customerService.save(form.getClient().toBLL())); // TODO est ce que le customer est sauvegardé en base de donnée ?
        reservation.setCustomer(customer);

        this.reservationService.save(reservation);

        return ResponseEntity.ok(ReservationDTO.toDTO(reservation));
    }

    @PatchMapping(path = "/{id:[0-9]+}/status")
    public ResponseEntity<ReservationDTO> changeReservationStatus(@PathVariable Long id, @RequestParam ReservationStatus  status){
        Reservation reservation = this.reservationService.readOneByKey(id).orElseThrow( () -> new HttpNotFoundException("Reservation with id :(" + id + ") does not exist"));

        switch (status) {
            case canceled -> reservationService.cancellation(reservation);
            case finished -> reservationService.ending(reservation);
        }

        this.reservationService.save(reservation);

        return ResponseEntity.ok(ReservationDTO.toDTO(reservation));
    }

    @DeleteMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<ReservationDTO> deleteReservation(@PathVariable Long id){
        Reservation reservation = this.reservationService.readOneByKey(id).orElseThrow(() -> new HttpNotFoundException("Reservation with id :(" + id + ") does not exist"));

        this.reservationService.deletion(reservation);
        this.reservationService.save(reservation);

        return ResponseEntity.ok(ReservationDTO.toDTO(reservation));
    }

}

package com.example.carlocation.controllers;

import com.example.carlocation.exceptions.HttpNotFoundException;
import com.example.carlocation.exceptions.HttpPreconditionFailedException;
import com.example.carlocation.models.dtos.reservation.ReservationDTO;
import com.example.carlocation.models.entities.Car;
import com.example.carlocation.models.entities.Customer;
import com.example.carlocation.models.entities.Reservation;
import com.example.carlocation.models.entities.ReservationStatus;
import com.example.carlocation.models.forms.ReservationAddForm;
import com.example.carlocation.services.car.CarService;
import com.example.carlocation.services.customer.CustomerService;
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

    private final CustomerService customerService;

    public ReservationController(ReservationService reservationService, CarService carService, CustomerService customerService) {
        this.reservationService = reservationService;
        this.carService = carService;
        this.customerService = customerService;
    }

    @Override
    @GetMapping(path = "/{id}:[0-9]+")
    public ResponseEntity<ReservationDTO> readOne(@PathVariable Long id) {
        Reservation reservation = this.reservationService.readOneByKey(id).orElseThrow(() -> new HttpNotFoundException("Reservation with id :(" + id + ") does not exist"));
        ReservationDTO reservationDTO = ReservationDTO.toDTO(reservation);
        reservationDTO.setIndicativePrice(reservation.getRentalFormula().getMaxKm() * reservation.getCar().getModel().getPricingClass().getPrice_km());
        return ResponseEntity.ok(reservationDTO);
    }

    @Override
    @GetMapping(path = "")
    public ResponseEntity<Collection<ReservationDTO>> readAll() {
        return ResponseEntity.ok(this.reservationService.readAll()
                .peek(r -> r.setIndicativePrice(r.getRentalFormula().getMaxKm() * r.getCar().getModel().getPricingClass().getPrice_km()))
                .map(ReservationDTO::toDTO)
                .toList());
    }
    @PostMapping(path = "")
    public ResponseEntity<ReservationDTO> addReservation(@Valid @RequestBody ReservationAddForm form){
        Reservation reservation = new Reservation();

        Car car = this.carService.readOneByKey(form.getIdCar()).orElseThrow(() -> new HttpNotFoundException("There is no car with id:(" + form.getIdCar()+ ")"));
        if (!this.carService.isAvailable(car,form.getRemoval(),form.getRestitution())){
            throw new HttpPreconditionFailedException("Car is not available", new ArrayList<>());
        }

        Customer customer = this.customerService
                .readOneByKey(form.getIdCustomer())
                .orElse(this.customerService.save(form.getClient().toBLL()));
        reservation.setCustomer(customer);

        try{
            reservation = this.reservationService.save(reservation);
        }catch (Exception exception){
            throw new HttpPreconditionFailedException("Form is not valid", new ArrayList<>());
        }
        return ResponseEntity.ok(ReservationDTO.toDTO(reservation));
    }

    @PatchMapping(path = "/{id:[0-9]+}/status")
    public ResponseEntity<ReservationDTO> changeReservationStatus(@PathVariable Long id, @RequestParam ReservationStatus  status){
        Reservation reservation = this.reservationService.readOneByKey(id).orElseThrow( () -> new HttpNotFoundException("Reservation with id :(" + id + ") does not exist"));

        switch (status) {
            case canceled -> reservationService.cancellation(reservation);
            case finished -> reservationService.restitution(reservation);
        }
        try {
            this.reservationService.save(reservation);
        }catch (Exception exception){
            throw new HttpPreconditionFailedException("Status can't be changed from status A to status B", new ArrayList<>());
        }
        return ResponseEntity.ok(ReservationDTO.toDTO(reservation));
    }

    @DeleteMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<ReservationDTO> deleteReservation(@PathVariable Long id){
        Reservation reservation = this.reservationService.readOneByKey(id).orElseThrow(() -> new HttpNotFoundException("Reservation with id :(" + id + ") does not exist"));
        try {
            this.reservationService.deletion(reservation);
            this.reservationService.save(reservation);
        } catch (Exception exception){
            throw new HttpPreconditionFailedException("Reservation can't be deleted", new ArrayList<>());
        }
        return ResponseEntity.ok(ReservationDTO.toDTO(reservation));
    }

}

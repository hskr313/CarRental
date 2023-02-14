package com.example.carlocation.controllers;

import com.example.carlocation.exceptions.HttpNotFoundException;
import com.example.carlocation.models.dtos.rental.RentalDTO;
import com.example.carlocation.models.entities.Rental;
import com.example.carlocation.services.rental.RentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/rental")
public class RentalController implements BaseRestController<RentalDTO, Long> {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
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
}

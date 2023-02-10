package com.example.carlocation.controllers;

import com.example.carlocation.services.rental.RentalService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }
}

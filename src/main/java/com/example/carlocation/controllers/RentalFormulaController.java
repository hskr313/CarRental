package com.example.carlocation.controllers;

import com.example.carlocation.services.rentalFormula.RentalFormulaService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentalFormulaController {

    private final RentalFormulaService rentalFormulaService;

    public RentalFormulaController(RentalFormulaService rentalFormulaService) {
        this.rentalFormulaService = rentalFormulaService;
    }
}

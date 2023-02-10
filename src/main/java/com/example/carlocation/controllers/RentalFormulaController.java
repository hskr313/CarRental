package com.example.carlocation.controllers;

import com.example.carlocation.models.dtos.rentalFormula.RentalFormulaDTO;
import com.example.carlocation.services.rentalFormula.RentalFormulaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class RentalFormulaController extends BaseRestController<RentalFormulaDTO, Long> {

    private final RentalFormulaService rentalFormulaService;

    public RentalFormulaController(RentalFormulaService rentalFormulaService) {
        this.rentalFormulaService = rentalFormulaService;
    }

    @Override
    @GetMapping
    public ResponseEntity<RentalFormulaDTO> readOne(Long id) {
        return null;
    }

    @Override
    @GetMapping()
    public ResponseEntity<Collection<RentalFormulaDTO>> readAll() {
        return null;
    }
}

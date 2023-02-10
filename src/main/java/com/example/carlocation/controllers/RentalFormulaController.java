package com.example.carlocation.controllers;

import com.example.carlocation.exceptions.HttpNotFoundException;
import com.example.carlocation.models.dtos.rentalFormula.RentalFormulaDTO;
import com.example.carlocation.models.entities.RentalFormula;
import com.example.carlocation.services.rentalFormula.RentalFormulaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class RentalFormulaController implements BaseRestController<RentalFormulaDTO, Long> {

    private final RentalFormulaService rentalFormulaService;

    public RentalFormulaController(RentalFormulaService rentalFormulaService) {
        this.rentalFormulaService = rentalFormulaService;
    }

    @Override
    @GetMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<RentalFormulaDTO> readOne(@PathVariable Long id) {
        RentalFormula formula = this.rentalFormulaService.readOneByKey(id).orElseThrow( () -> new HttpNotFoundException("There is no formula with this id: " + id));
        return ResponseEntity.ok(RentalFormulaDTO.toDTO(formula));
    }

    @Override
    @GetMapping(path = "")
    public ResponseEntity<Collection<RentalFormulaDTO>> readAll() {
        return ResponseEntity.ok(this.rentalFormulaService.readAll()
                .map(RentalFormulaDTO::toDTO)
                .toList());
    }
}

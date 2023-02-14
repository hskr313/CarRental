package com.example.carlocation.controllers;

import com.example.carlocation.exceptions.HttpNotFoundException;
import com.example.carlocation.exceptions.HttpPreconditionFailedException;
import com.example.carlocation.models.dtos.rentalFormula.RentalFormulaDTO;
import com.example.carlocation.models.entities.RentalFormula;
import com.example.carlocation.models.forms.RentalFormulaAddForm;
import com.example.carlocation.services.rentalFormula.RentalFormulaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping(path = "rentalFormula")
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

    @PostMapping(path = "")
    public ResponseEntity<RentalFormulaDTO> addOne(@Valid @RequestBody RentalFormulaAddForm form){
        RentalFormula formula = form.toBLL();
        try{
            formula = this.rentalFormulaService.save(formula);
        } catch (Exception exception) {
            throw new HttpPreconditionFailedException(exception.getMessage(), new ArrayList<>());
        }
        return ResponseEntity.ok(RentalFormulaDTO.toDTO(formula));
    }
}

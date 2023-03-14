package com.example.carlocation.controllers;

import com.example.carlocation.exceptions.HttpPreconditionFailedException;
import com.example.carlocation.models.dtos.pricingClass.PricingClassDTO;
import com.example.carlocation.models.entities.PricingClass;
import com.example.carlocation.models.forms.PricingClassAddForm;
import com.example.carlocation.services.pricingClass.PricingClassService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping(path = "/pricingClass")
public class PricingClassController implements BaseRestController<PricingClassDTO, Long> {

    private final PricingClassService pricingClassService;

    public PricingClassController(PricingClassService pricingClassService) {
        this.pricingClassService = pricingClassService;
    }
    @GetMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<PricingClassDTO> readOne(@PathVariable Long id) {
        return null;
    }
    @GetMapping(path = "")
    public ResponseEntity<Collection<PricingClassDTO>> readAll() {
        return ResponseEntity.ok(this.pricingClassService.readAll()
                .map(PricingClassDTO::toDTO)
                .toList());
    }

    @PostMapping(path = "")
    public ResponseEntity<PricingClassDTO> addOne(@Valid @RequestBody PricingClassAddForm form){
        PricingClass pricing = form.toBLL();

            this.pricingClassService.save(pricing);

        return ResponseEntity.ok(PricingClassDTO.toDTO(pricing));
    }
}

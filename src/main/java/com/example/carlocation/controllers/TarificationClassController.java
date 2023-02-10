package com.example.carlocation.controllers;

import com.example.carlocation.models.dtos.tarificationClass.TarificationClassDTO;
import com.example.carlocation.services.tarificationClass.TartificationClassService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class TarificationClassController implements BaseRestController<TarificationClassDTO, Long> {

    private final TartificationClassService tartificationClassService;

    public TarificationClassController(TartificationClassService tartificationClassService) {
        this.tartificationClassService = tartificationClassService;
    }
    @GetMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<TarificationClassDTO> readOne(@PathVariable Long id) {
        return null;
    }
    @GetMapping(path = "")
    public ResponseEntity<Collection<TarificationClassDTO>> readAll() {
        return ResponseEntity.ok(this.tartificationClassService.readAll()
                .map(TarificationClassDTO::toDTO)
                .toList());
    }
}

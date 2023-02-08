package com.example.carlocation.controllers;

import com.example.carlocation.services.tarificationClass.TartificationClassService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TarificationClassController {

    private final TartificationClassService tartificationClassService;

    public TarificationClassController(TartificationClassService tartificationClassService) {
        this.tartificationClassService = tartificationClassService;
    }
}

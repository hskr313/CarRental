package com.example.carlocation.controllers;

import com.example.carlocation.services.option.OptionService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OptionController {

    private final OptionService optionService;

    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }
}

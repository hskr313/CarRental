package com.example.carlocation.controllers;

import com.example.carlocation.services.insuranceContract.InsuranceContractService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InsuranceContractController {

    private final InsuranceContractService insuranceContractService;

    public InsuranceContractController(InsuranceContractService insuranceContractService) {
        this.insuranceContractService = insuranceContractService;
    }
}

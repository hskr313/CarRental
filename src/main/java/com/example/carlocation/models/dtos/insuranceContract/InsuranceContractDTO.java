package com.example.carlocation.models.dtos.insuranceContract;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InsuranceContractDTO {

    private Long id;

    private String typeContract;

}

package com.example.carlocation.models.dtos.insuranceContract;

import com.example.carlocation.models.entities.InsuranceContract;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InsuranceContractDTO {

    private Long id;

    private String typeContract;

    public static InsuranceContractDTO toDTO(InsuranceContract insuranceContract){
        return InsuranceContractDTO.builder()
                .id(insuranceContract.getId())
                .typeContract(insuranceContract.getTypeContract())
                .build();
    }

}

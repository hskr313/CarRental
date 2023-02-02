package com.example.carlocation.models.dtos.insuranceContract;

import com.example.carlocation.models.dtos.AddressDTO;
import com.example.carlocation.models.entities.Address;
import com.example.carlocation.models.entities.InsuranceContract;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InsuranceContractDTO {

    private Long id;

    private String typeContract;

    private String insuranceName;

    private String insuranceContact;

    private AddressDTO insuranceAddress;

    public static InsuranceContractDTO toDTO(InsuranceContract insuranceContract){
        return InsuranceContractDTO.builder()
                .id(insuranceContract.getId())
                .typeContract(insuranceContract.getTypeContract())
                .insuranceName(insuranceContract.getInsuranceName())
                .insuranceContact(insuranceContract.getInsuranceContact())
                .insuranceAddress(AddressDTO.toDTO(insuranceContract.getInsuranceAddress()))
                .build();
    }

}

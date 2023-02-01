package com.example.carlocation.models.dtos.insurance;

import com.example.carlocation.models.dtos.AddressDTO;
import com.example.carlocation.models.entities.Insurance;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InsuranceDTO {

    private Integer id;

    private String name;

    private AddressDTO address;

    private Long phone;

    private Long fax;

    public static InsuranceDTO toDTO(Insurance insurance){
        return InsuranceDTO.builder()
                .id(insurance.getId())
                .name(insurance.getName())
                .address(AddressDTO.toDTO(insurance.getAddress()))
                .phone(insurance.getPhone())
                .fax(insurance.getFax())
                .build();
    }

}

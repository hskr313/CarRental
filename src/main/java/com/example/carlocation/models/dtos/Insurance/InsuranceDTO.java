package com.example.carlocation.models.dtos.Insurance;

import com.example.carlocation.models.entities.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InsuranceDTO {

    private Long id;

    private String name;

    private Address address;

    private Long phone;

    private Long fax;

}

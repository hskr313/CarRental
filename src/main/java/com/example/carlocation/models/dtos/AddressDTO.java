package com.example.carlocation.models.dtos;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDTO {

    private String street;

    private String number;

    private String postalCode;

    private String city;

    private String country = "Belgium";

}

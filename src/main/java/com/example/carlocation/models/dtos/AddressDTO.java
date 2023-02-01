package com.example.carlocation.models.dtos;

import com.example.carlocation.models.entities.Address;
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

    public static AddressDTO toDTO(Address address){
        return AddressDTO.builder()
                .street(address.getStreet())
                .number(address.getNumber())
                .postalCode(address.getPostalCode())
                .city(address.getCity())
                .country(address.getCountry())
                .build();
    }
}

package com.example.carlocation.models.forms;

import com.example.carlocation.models.entities.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressForm {

    private String street;

    private String number;

    private String postalCode;

    private String city;

    private String country = "Belgium";

    public Address toBLL(){
        return Address.builder()
                .street(street)
                .number(number)
                .postalCode(postalCode)
                .city(city)
                .country(country)
                .build();
    }
}

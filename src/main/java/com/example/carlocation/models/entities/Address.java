package com.example.carlocation.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Column(name = "address_street")
    private String street;
    @Column(name = "address_number")
    private String number;
    @Column(name = "address_postalCode")
    private String postalCode;
    @Column(name = "address_city")
    private String city;
    @Column(name = "address_country")
    private String country = "Belgium";
}

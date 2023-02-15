package com.example.carlocation.models.forms;

import com.example.carlocation.models.entities.Rental;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class RentalAddForm {

    private Long startKm;

    private Long licenseNumber;

    private Long reservationId;

    public Rental toBLL(){

        return Rental.builder()
                .startKm(startKm)
                .licenseNumber(licenseNumber)
                .build();
    }

}

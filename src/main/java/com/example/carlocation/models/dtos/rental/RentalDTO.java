package com.example.carlocation.models.dtos.rental;

import com.example.carlocation.models.dtos.reservation.ReservationDTO;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class RentalDTO {

    private Long id;

    private Long startKm;

    private Long licenseNumber;

    private int deposit;

    private LocalDate returnDate;

    private Long returnKm;

    private ReservationDTO reservation;

}

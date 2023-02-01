package com.example.carlocation.models.dtos.rental;

import com.example.carlocation.models.dtos.reservation.ReservationDTO;
import com.example.carlocation.models.entities.Rental;
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

    public static RentalDTO toDTO(Rental rental){
        return RentalDTO.builder()
                .id(rental.getId())
                .startKm(rental.getStartKm())
                .licenseNumber(rental.getLicenseNumber())
                .deposit(rental.getDeposit())
                .returnDate(rental.getReturnDate())
                .returnKm(rental.getReturnKm())
                .reservation(ReservationDTO.toDTO(rental.getReservation()))
                .build();
    }
}

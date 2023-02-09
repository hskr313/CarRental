package com.example.carlocation.models.dtos.rental;

import com.example.carlocation.models.dtos.car.CarDTO;
import com.example.carlocation.models.dtos.reservation.ReservationDTO;
import com.example.carlocation.models.entities.Car;
import com.example.carlocation.models.entities.Rental;
import com.example.carlocation.models.entities.TarificationFormula;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class RentalDTO {

    private Long id;

    private Long startKm;

    private Long licenseNumber;

    private double deposit;

    private LocalDate returnDate;

    private Long returnKm;

    private ReservationDTO reservation;

    public static RentalDTO toDTO(Rental rental){
        if (rental == null) return null;
        return RentalDTO.builder()
                .id(rental.getId())
                .startKm(rental.getStartKm())
                .licenseNumber(rental.getLicenseNumber())
                .returnDate(rental.getReturnDate())
                .returnKm(rental.getReturnKm())
                .reservation(ReservationDTO.toDTO(rental.getReservation()))
                .build();
    }
}

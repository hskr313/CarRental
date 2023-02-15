package com.example.carlocation.models.dtos.rental;

import com.example.carlocation.models.dtos.fin.FinDTO;
import com.example.carlocation.models.dtos.reservation.ReservationDTO;
import com.example.carlocation.models.entities.Rental;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    List<FinDTO> fins;

    public static RentalDTO toDTO(Rental rental){
        if (rental == null) return null;
        return RentalDTO.builder()
                .id(rental.getId())
                .startKm(rental.getStartKm())
                .licenseNumber(rental.getLicenseNumber())
                .returnDate(rental.getReturnDate())
                .returnKm(rental.getReturnKm())
                .reservation(ReservationDTO.toDTO(rental.getReservation()))
                .fins(rental.getFins().stream()
                        .map(FinDTO::ToDTO)
                        .toList())
                .build();
    }
}

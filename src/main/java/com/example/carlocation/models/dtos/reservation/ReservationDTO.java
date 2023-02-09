package com.example.carlocation.models.dtos.reservation;

import com.example.carlocation.models.dtos.car.CarDTO;
import com.example.carlocation.models.dtos.client.ClientDTO;
import com.example.carlocation.models.dtos.rental.RentalDTO;

import com.example.carlocation.models.dtos.rentalFormula.RentalFormulaDTO;
import com.example.carlocation.models.entities.RentalFormula;
import com.example.carlocation.models.entities.Reservation;
import com.example.carlocation.models.entities.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {

    private Long id;

    private LocalDate removal;

    private LocalDate theoricRestitution;

    private LocalDate restitution;

    private ReservationStatus reservStatus;

    private ReservationDTO substitution;

    private RentalDTO rental;

    private ClientDTO client;

    private RentalFormulaDTO rentalFormula;

    private LocalDate cancellationDate;

    private double finDeleted;

    public static ReservationDTO toDTO(Reservation reservation){
        if (reservation == null) return null;
        return ReservationDTO.builder()
                .id(reservation.getId())
                .removal(reservation.getRemoval())
                .theoricRestitution(reservation.getTheoricRestitution())
                .restitution(reservation.getRestitution())
                .reservStatus(reservation.getReservStatus())
                .substitution(ReservationDTO.toDTO(reservation.getSubstitution()))
                .rental(RentalDTO.toDTO(reservation.getRental()))
                .client(ClientDTO.toDTO(reservation.getClient()))
                .rentalFormula(RentalFormulaDTO.toDTO(reservation.getRentalFormula()))
                .cancellationDate(reservation.getCancellationDate())
                .finDeleted(reservation.getFinDeleted())
                .build();
    }

}

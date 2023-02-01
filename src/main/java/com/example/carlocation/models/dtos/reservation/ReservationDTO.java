package com.example.carlocation.models.dtos.reservation;

import com.example.carlocation.models.dtos.client.ClientDTO;
import com.example.carlocation.models.dtos.rental.RentalDTO;

import com.example.carlocation.models.entities.Reservation;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder
public class ReservationDTO {

    private Long id;

    private LocalDate removal;

    private LocalDate restitution;

    private String reservStatus;

    private ReservationDTO substitution;

    private RentalDTO rental;

    private ClientDTO client;

    public static ReservationDTO toDTO(Reservation reservation){
        return ReservationDTO.builder()
                .id(reservation.getId())
                .removal(reservation.getRemoval())
                .restitution(reservation.getRestitution())
                .reservStatus(reservation.getReservStatus())
                .substitution(ReservationDTO.toDTO(reservation.getSubstitution()))
                .rental(RentalDTO.toDTO(reservation.getRental()))
                .client(ClientDTO.toDTO(reservation.getClient()))
                .build();
    }

}

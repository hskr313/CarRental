package com.example.carlocation.models.dtos.reservation;

import com.example.carlocation.models.dtos.client.ClientDTO;
import com.example.carlocation.models.dtos.rental.RentalDTO;

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

}

package com.example.carlocation.models.forms;

import com.example.carlocation.models.dtos.client.ClientDTO;
import com.example.carlocation.models.dtos.rental.RentalDTO;
import com.example.carlocation.models.dtos.reservation.ReservationDTO;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ReservationAddForm {

    private LocalDate removal;

    private LocalDate restitution;

    private String reservStatus;

    private RentalDTO rental;

    private Long idClient;
}

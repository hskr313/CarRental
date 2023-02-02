package com.example.carlocation.models.forms;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ReservationAddForm {

    private LocalDate removal;

    private LocalDate restitution;

    private String reservStatus;

    private Long idClient;
}

package com.example.carlocation.models.forms;

import com.example.carlocation.models.entities.Reservation;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ReservationAddForm {

    private LocalDate removal;

    private LocalDate restitution;

    private RentalFormulaAddForm rentalFormula;

    private Long idCar;

    private Long idCustomer;

    private ClientAddForm client;

    public Reservation toBLL(){
        return Reservation.builder()
                .removal(removal)
                .restitution(restitution)
                .rentalFormula(rentalFormula.toBLL())
                .build();
    }
}

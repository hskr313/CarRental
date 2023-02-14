package com.example.carlocation.models.forms;

import com.example.carlocation.models.entities.Reservation;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ReservationAddForm {

    private LocalDate removal;

    private LocalDate restitution;

    private RentalFormulaAddForm rentalFormula; // TODO utiliser uniquement l'id

    private Long idCar;

    private Long idCustomer;

    private CustomerAddForm client;

    public Reservation toBLL(){
        return Reservation.builder()
                .removal(removal)
                .restitution(restitution)
                .rentalFormula(rentalFormula.toBLL())
                .build();
    }
}

package com.example.carlocation.models.forms;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class RentalReturnForm {

    private LocalDate returnDate;

    private Long returnKm;

    private Long rentalId;

}

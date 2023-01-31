package com.example.carlocation.models.dtos.rentalFormula;

import com.example.carlocation.models.entities.RentalFormula;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RentalFormulaDTO {

    private Long id;

    private RentalFormula.Formula rentalType;

    private Long maxKm;

}

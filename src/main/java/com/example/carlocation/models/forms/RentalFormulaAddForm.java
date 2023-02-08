package com.example.carlocation.models.forms;

import com.example.carlocation.models.entities.RentalFormula;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RentalFormulaAddForm {

    private RentalFormula.Formula rentalType;

    private Long maxKm;

    public RentalFormula toBLL(){
        return RentalFormula.builder()
                .rentalType(rentalType)
                .maxKm(maxKm)
                .build();
    }
}

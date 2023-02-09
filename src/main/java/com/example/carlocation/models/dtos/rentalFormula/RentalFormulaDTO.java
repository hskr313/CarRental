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

    public static RentalFormulaDTO toDTO(RentalFormula rentalFormula){
        if (rentalFormula == null) return null;
        return RentalFormulaDTO.builder()
                .id(rentalFormula.getId())
                .rentalType(rentalFormula.getRentalType())
                .maxKm(rentalFormula.getMaxKm())
                .build();
    }

}

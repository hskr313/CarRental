package com.example.carlocation.models.dtos.tarificationFormula;

import com.example.carlocation.models.dtos.rentalFormula.RentalFormulaDTO;
import com.example.carlocation.models.dtos.tarificationClass.TarificationClassDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TarificationFormulaDTO {

    private Long id;

    private int lumpSum;

    private RentalFormulaDTO rentalFormula;

    private TarificationClassDTO tarificationClass;

    public int getLumpSum() {
        return (int) (rentalFormula.getMaxKm() * tarificationClass.getPrice_km());
    }

}

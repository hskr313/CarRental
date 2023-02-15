package com.example.carlocation.models.dtos.fin;

import com.example.carlocation.models.entities.Fin;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FinDTO {

    private String reason;

    private double amount;

    private boolean paid;

    public static FinDTO ToDTO(Fin fin){
        if (fin == null) return null;
        return FinDTO.builder()
                .reason(fin.getReason())
                .amount(fin.getAmount())
                .paid(fin.isPaid())
                .build();
    }

}

package com.example.carlocation.models.dtos.tarificationClass;

import com.example.carlocation.models.dtos.insuranceContract.InsuranceContractDTO;
import com.example.carlocation.models.dtos.model.ModelDTO;
import com.example.carlocation.models.entities.TarificationClass;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class TarificationClassDTO {

    private Long id;

    private int price_km;

    private int fine_day;

    private List<ModelDTO> models;

    private List<InsuranceContractDTO> contractList;

    public static TarificationClassDTO toDTO(TarificationClass tarificationClass){
        return TarificationClassDTO.builder()
                .id(tarificationClass.getId())
                .price_km(tarificationClass.getPrice_km())
                .fine_day(tarificationClass.getFine_day())
                .models(tarificationClass.getModels().stream()
                        .map(ModelDTO::toDTO)
                        .toList())
                .contractList(tarificationClass.getContractList().stream()
                        .map(InsuranceContractDTO::toDTO)
                        .toList())
                .build();
    }
}

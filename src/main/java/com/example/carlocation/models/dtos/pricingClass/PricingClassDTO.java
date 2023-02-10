package com.example.carlocation.models.dtos.pricingClass;

import com.example.carlocation.models.dtos.insuranceContract.InsuranceContractDTO;
import com.example.carlocation.models.dtos.model.ModelDTO;
import com.example.carlocation.models.entities.PricingClass;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class PricingClassDTO {

    private Long id;

    private int price_km;

    private int fine_day;

    private List<ModelDTO> models;

    private List<InsuranceContractDTO> contractList;

    public static PricingClassDTO toDTO(PricingClass pricingClass){
        if (pricingClass == null) return null;
        return PricingClassDTO.builder()
                .id(pricingClass.getId())
                .price_km(pricingClass.getPrice_km())
                .fine_day(pricingClass.getFine_day())
                .models(pricingClass.getModels().stream()
                        .map(ModelDTO::toDTO)
                        .toList())
                .contractList(pricingClass.getContractList().stream()
                        .map(InsuranceContractDTO::toDTO)
                        .toList())
                .build();
    }
}

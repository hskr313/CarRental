package com.example.carlocation.models.dtos.tarificationClass;

import com.example.carlocation.models.dtos.insuranceContract.InsuranceContractDTO;
import com.example.carlocation.models.dtos.model.ModelDTO;
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

}

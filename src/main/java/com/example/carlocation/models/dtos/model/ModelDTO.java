package com.example.carlocation.models.dtos.model;

import com.example.carlocation.models.dtos.option.OptionDTO;
import com.example.carlocation.models.dtos.tarificationClass.TarificationClassDTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ModelDTO {

    private Long id;

    private String brand;

    private String type;

    private int power;

    private TarificationClassDTO tarificationClass;

    private List<OptionDTO> options;

}

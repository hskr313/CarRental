package com.example.carlocation.models.dtos.option;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OptionDTO {

    private Long id;

    private String optionName;

}

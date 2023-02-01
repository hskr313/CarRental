package com.example.carlocation.models.dtos.option;

import com.example.carlocation.models.entities.Option;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OptionDTO {

    private Integer id;

    private String optionName;

    public static OptionDTO toDTO(Option option){
        if ( option == null) return null;
        return OptionDTO.builder()
                .id(option.getId())
                .optionName(option.getOptionName())
                .build();
    }

}

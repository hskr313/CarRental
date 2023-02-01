package com.example.carlocation.models.forms;

import com.example.carlocation.models.entities.Option;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
public class OptionAddForm {
    private String optionName;

    public Option toBLL(){
        return Option.builder()
                .optionName(optionName)
                .build();
    }
}

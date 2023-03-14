package com.example.carlocation.models.forms;

import com.example.carlocation.models.entities.Option;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OptionAddForm {
    private String option;

    public Option toBLL(){
        return Option.builder()
                .optionName(option)
                .build();
    }
}

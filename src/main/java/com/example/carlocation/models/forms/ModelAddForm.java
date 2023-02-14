package com.example.carlocation.models.forms;

import com.example.carlocation.models.entities.Model;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
public class ModelAddForm {

    private List<OptionAddForm> options;

    private PricingClassAddForm pricingClass; // TODO Changer ici

    private String brand;

    private String type;

    private int power;

    public Model toBLL(){

        Model.ModelId modelId = new Model.ModelId();
        modelId.setBrand(brand);
        modelId.setType(type);
        modelId.setPower(power);
        return Model.builder()
                .options(options.stream()
                        .map(OptionAddForm::toBLL)
                        .toList())
                .id(modelId)
                .build();
    }
}

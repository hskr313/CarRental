package com.example.carlocation.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Model extends RelationalEntity<Model.ModelId>{

    @EmbeddedId
    private ModelId id;

    @ManyToMany(targetEntity = Option.class)
    private List<Option> options;

    @ManyToOne
    @MapsId("pricingClassId")
    private PricingClass pricingClass;

    @Embeddable
    @Data
    public static class ModelId implements Serializable {

        private String brand;

        private String type;

        private int power;
    }
}

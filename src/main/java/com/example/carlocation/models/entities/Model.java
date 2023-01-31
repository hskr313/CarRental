package com.example.carlocation.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Model extends RelationalEntity<Model.ModelId>{

    @ManyToMany(targetEntity = Option.class)
    private List<Option> options;

    @ManyToOne
    @MapsId("tarificationClassId")
    private TarificationClass tarificationClass;

    @Embeddable
    @Data
    public static class ModelId implements Serializable {

        private String brand;

        private String type;

        private int power;
    }
}

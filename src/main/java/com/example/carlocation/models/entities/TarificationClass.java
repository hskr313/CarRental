package com.example.carlocation.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TarificationClass extends BaseEntity<Long>{

    @Column(nullable = false)
    private int price_km;

    @Column(nullable = false)
    private int fine_day;

    @OneToMany(mappedBy = "tarificationClass")
    private List<Model> models;

    @ManyToMany
    private List<InsuranceContract> contractList;

}

package com.example.carlocation.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PricingClass extends BaseEntity<Long>{

    @Column(nullable = false)
    private int price_km;

    @Column(nullable = false)
    private int fine_day;

    @OneToMany(mappedBy = "pricingClass")
    private List<Model> models;

    @ManyToMany
    private List<InsuranceContract> contractList;

    @ManyToMany
    private List<RentalFormula> formulas;
}

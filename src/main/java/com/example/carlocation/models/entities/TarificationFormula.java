package com.example.carlocation.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TarificationFormula extends BaseEntity<Long> {

    @Column(nullable = false)
    private int lumpSum;

    @ManyToOne(targetEntity = RentalFormula.class)
    private RentalFormula rentalFormula;

    @ManyToOne(targetEntity = TarificationClass.class)
    private TarificationClass tarificationClass;
}

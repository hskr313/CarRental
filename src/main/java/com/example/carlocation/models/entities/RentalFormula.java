package com.example.carlocation.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RentalFormula extends BaseEntity<Long> {

    @Column(nullable = false)
    @Embedded
    @Enumerated
    private Formula rentalType;

    @Column(nullable = false)
    private Long maxKm;

    @Embeddable
    public enum Formula{

        DAY_RENT,
        WEEK_RENT,
        WEEK_END_RENT
    }
}

package com.example.carlocation.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Rental extends BaseEntity<Long>{

    @Column(nullable = false)
    private Long startKm;

    @Column(nullable = false)
    private Long licenseNumber;

    @Column(nullable = false)
    private int deposit;

    @Column(nullable = false)
    private LocalDate returnDate;

    @Column(nullable = false)
    private Long returnKm;

    @OneToOne
    private Reservation reservation;
}

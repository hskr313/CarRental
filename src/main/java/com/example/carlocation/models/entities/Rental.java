package com.example.carlocation.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Rental extends BaseEntity<Long>{

    @Column(nullable = false)
    private Long startKm;

    @Column(nullable = false)
    private Long licenseNumber;

    @Column(nullable = false)
    private double deposit;

    @Column(nullable = false)
    private LocalDate returnDate;

    @Column(nullable = false)
    private Long returnKm;

    @OneToOne
    private Reservation reservation;

    @OneToMany
    List<Fin> fins = new ArrayList<>();
}

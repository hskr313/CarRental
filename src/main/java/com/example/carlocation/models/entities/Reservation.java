package com.example.carlocation.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reservation extends BaseEntity<Long>{

    @Column(nullable = false)
    private LocalDate removal;
    @Column(nullable = false)
    private LocalDate restitution;

    private String reservStatus;

    @OneToOne
    private Reservation substitution;

    @OneToOne(mappedBy = "reservation")
    private Rental rental;

    @ManyToOne
    @MapsId("ClientId")
    private Client client;

    @ManyToOne
    private RentalFormula rentalFormula;

    //TODO faire une enumeration pour le status de reservation ou une table ?
}

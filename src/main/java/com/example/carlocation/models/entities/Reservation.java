package com.example.carlocation.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
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
}

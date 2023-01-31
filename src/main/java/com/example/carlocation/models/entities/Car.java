package com.example.carlocation.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car extends BaseEntity<Long> {

    @Column(nullable = false)
    private int buyPrice;
    @Column(nullable = false)
    private LocalDate buyDate;
    @Column(nullable = false)
    private Long km;

    private String supplier;

    private boolean repair = false;

    private LocalDate returnDate;

    @ManyToOne
    @MapsId("modelId")
    private Model model;

    @OneToMany
    private List<Reservation> reservations;

    //TODO demander si je dois redefinir mon setter pour la date
}

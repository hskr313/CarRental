package com.example.carlocation.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    private int indicativePrice;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @MapsId("modelId")
    private Model model;

    @OneToMany
    private List<Reservation> reservations = new ArrayList<>();

    //TODO demander si je dois redefinir mon setter pour la date
}

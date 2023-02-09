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
    private LocalDate theoricRestitution;
    private LocalDate restitution;

    @Enumerated(EnumType.ORDINAL)
    private ReservationStatus reservStatus;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Reservation substitution;

    @OneToOne(mappedBy = "reservation")
    private Rental rental;

    @ManyToOne
    @MapsId("ClientId")
    private Client client;

    @ManyToOne
    private RentalFormula rentalFormula;

    private LocalDate cancellationDate;

    private double finDeleted;

    public void delete() {
        this.cancellationDate = LocalDate.now();
    }

    public void cancel(){
        this.substitution = new Reservation();
    }

    public void finish(){
        this.restitution = LocalDate.now();
    }
}

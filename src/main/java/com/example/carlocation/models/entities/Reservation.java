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
    @MapsId("CustomerId")
    private Customer customer;

    @ManyToOne
    private RentalFormula rentalFormula;

    @ManyToOne
    private Car car;

    private LocalDate cancellationDate;

    private double finDeleted;

    private double indicativePrice;

    private LocalDate closingDate;

    public void delete() {
        this.cancellationDate = LocalDate.now();
    }

    public void cancel(){
        this.substitution = new Reservation();
    }

    public void finish(){
        this.closingDate = LocalDate.now();
    }
}

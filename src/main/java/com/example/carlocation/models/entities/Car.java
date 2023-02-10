package com.example.carlocation.models.entities;

import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @MapsId("modelId")
    private Model model;


}

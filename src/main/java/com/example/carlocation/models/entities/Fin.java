package com.example.carlocation.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Fin extends BaseEntity<Long>{

    private String reason;

    private double amount;

    private boolean paid = false;

}

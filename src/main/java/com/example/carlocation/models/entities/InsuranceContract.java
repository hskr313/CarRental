package com.example.carlocation.models.entities;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class InsuranceContract extends BaseEntity<Long> {

    @Column(nullable = false)
    private String typeContract;

    private String insuranceName;

    private String insuranceContact;

    private Address insuranceAddress;

}

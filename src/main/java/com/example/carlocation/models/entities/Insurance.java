package com.example.carlocation.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Insurance extends BaseEntity<Integer>{
    @Column(nullable = false)
    private String name;
    @Embedded
    private Address address;
    @Column(nullable = false)
    private Long phone;

    private Long fax;
}

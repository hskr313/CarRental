package com.example.carlocation.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer extends BaseEntity<Long>{

    @Column(nullable = false)
    private String fisrtname;
    @Column(nullable = false)
    private String lastname;

    @Embedded
    private Address address;

}

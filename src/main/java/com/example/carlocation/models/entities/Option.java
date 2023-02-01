package com.example.carlocation.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Option extends BaseEntity<Integer>{

    @Column(nullable = false, unique = true)
    private String optionName;
}

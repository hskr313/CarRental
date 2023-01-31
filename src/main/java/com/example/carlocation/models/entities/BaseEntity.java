package com.example.carlocation.models.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity<TKey extends Serializable> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private TKey id;

    @CreatedDate
    private LocalDate createdAt;

    @LastModifiedDate
    private LocalDate updatedAt;
}

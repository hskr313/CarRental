package com.example.carlocation.repositories;

import com.example.carlocation.models.entities.PricingClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricingClassRepository extends JpaRepository<PricingClass, Long> {
}

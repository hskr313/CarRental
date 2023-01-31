package com.example.carlocation.repositories;

import com.example.carlocation.models.entities.RentalFormula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalFormulaRepository extends JpaRepository<RentalFormula, Long> {
}

package com.example.carlocation.repositories;

import com.example.carlocation.models.entities.TarificationFormula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarificationFormulaRepository extends JpaRepository<TarificationFormula, Long> {
}

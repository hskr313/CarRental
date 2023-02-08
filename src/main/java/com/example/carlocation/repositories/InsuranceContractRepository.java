package com.example.carlocation.repositories;

import com.example.carlocation.models.entities.InsuranceContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceContractRepository extends JpaRepository<InsuranceContract, Long> {
}

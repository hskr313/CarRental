package com.example.carlocation.repositories;

import com.example.carlocation.models.entities.TarificationClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarificationClassRepository extends JpaRepository<TarificationClass, Long> {
}

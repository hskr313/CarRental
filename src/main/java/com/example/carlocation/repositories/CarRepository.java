package com.example.carlocation.repositories;

import com.example.carlocation.models.entities.Car;
import com.example.carlocation.models.entities.Option;
import com.example.carlocation.models.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  CarRepository extends JpaRepository<Car, Long> {
    @Query(value = "SELECT c FROM Car c JOIN c.reservations r WHERE r = :res")
    Optional<Car> findOneByReservation(@Param("res") Reservation reservation);
}

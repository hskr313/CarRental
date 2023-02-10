package com.example.carlocation.repositories;

import com.example.carlocation.models.entities.Car;
import com.example.carlocation.models.entities.Customer;
import com.example.carlocation.models.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query(value = "SELECT r FROM Reservation r JOIN r.car c WHERE c = :car")
    List<Reservation> findAllByCar(@Param("car") Car car);
    @Query(value = "SELECT r FROM Reservation r JOIN r.customer c WHERE c = :customer")
    List<Reservation> findAllByCustomer(@Param("customer") Customer customer);
}

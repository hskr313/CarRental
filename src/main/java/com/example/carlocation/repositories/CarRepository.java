package com.example.carlocation.repositories;

import com.example.carlocation.models.entities.Car;
import com.example.carlocation.models.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public interface  CarRepository extends JpaRepository<Car, Long> {
    @Query(value = "SELECT c, MIN(pc.price_km * f.maxKm) FROM Car c JOIN c.model m JOIN m.pricingClass pc JOIN pc.formulas f WHERE c.id = :id GROUP BY c")
    Map<Car, Double> getCarMinPrice(@Param("id") Long id);

    @Query(value = "SELECT pc.price_km * f.maxKm FROM Car c JOIN c.model m JOIN m.pricingClass pc JOIN pc.formulas f WHERE c.id = :id AND pc.id = :pcId AND f.id = :fId")
    double getIndicativePriceByPricingAndFormula(@Param("id") Long id, @Param("pcId") Long pcId, @Param("fId") Long fId);
}

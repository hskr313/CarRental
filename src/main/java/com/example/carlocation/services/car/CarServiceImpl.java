package com.example.carlocation.services.car;

import com.example.carlocation.models.Period;
import com.example.carlocation.models.entities.Car;
import com.example.carlocation.models.entities.Reservation;
import com.example.carlocation.repositories.CarRepository;
import com.example.carlocation.repositories.ReservationRepository;
import com.example.carlocation.services.CrudServiceImpl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CarServiceImpl extends CrudServiceImpl<CarRepository, Car, Long>
        implements CarService{

    private final ReservationRepository  reservationRepository;

    public CarServiceImpl(CarRepository repository, ReservationRepository reservationRepository) {
        super(repository);
        this.reservationRepository = reservationRepository;
    }

    @Override
    public boolean isAvailable(Car car, LocalDate startAt, LocalDate endAt) {
        return reservationRepository.findAllByCar(car).stream().noneMatch(it -> {
            Period bookPeriod = new Period(it.getRemoval(), it.getRestitution());
            Period tryToBookPeriod = new Period(startAt, endAt);
            return tryToBookPeriod.isOverlap(bookPeriod);
        });
    }

    @Override
    public List<Car> getCarsByAvailable(LocalDate startAt, LocalDate endAt) {
        return this.repository.findAll().stream()
                .filter(car -> this.isAvailable(car,startAt,endAt))
                .toList();
    }

    @Override
    public double getIndicativePriceByPricingAndFormula(Long id, Long pcId, Long fId) {
        return this.repository.getIndicativePriceByPricingAndFormula(id,pcId,fId);
    }
}

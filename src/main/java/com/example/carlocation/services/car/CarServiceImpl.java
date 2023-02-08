package com.example.carlocation.services.car;

import com.example.carlocation.models.Period;
import com.example.carlocation.models.entities.Car;
import com.example.carlocation.repositories.CarRepository;
import com.example.carlocation.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CarServiceImpl extends CrudServiceImpl<CarRepository, Car, Long>
        implements CarService{

    public CarServiceImpl(CarRepository repository) {
        super(repository);
    }

    @Override
    public boolean isAvailable(Car car, LocalDate startAt, LocalDate endAt) {
        return car.getReservations().stream().noneMatch(it -> {
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
}

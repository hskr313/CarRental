package com.example.carlocation.services.car;

import com.example.carlocation.models.entities.Car;
import com.example.carlocation.services.CrudService;

import java.time.LocalDate;
import java.util.List;

public interface CarService extends CrudService<Car, Long> {

    boolean isAvailable(Car car, LocalDate startAt, LocalDate endAt);

    List<Car> getCarsByAvailable(LocalDate startAt, LocalDate endAt);

}

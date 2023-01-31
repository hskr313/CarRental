package com.example.carlocation.services.car;

import com.example.carlocation.models.entities.Car;
import com.example.carlocation.repositories.CarRepository;
import com.example.carlocation.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends CrudServiceImpl<CarRepository, Car, Long>
        implements CarService{

    public CarServiceImpl(CarRepository repository) {
        super(repository);
    }
}

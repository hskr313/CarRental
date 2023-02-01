package com.example.carlocation.controllers;

import com.example.carlocation.exceptions.HttpNotFoundException;
import com.example.carlocation.exceptions.HttpPreconditionFailedException;
import com.example.carlocation.models.dtos.car.CarDTO;
import com.example.carlocation.models.entities.Car;
import com.example.carlocation.models.forms.car.CarAddForm;
import com.example.carlocation.services.car.CarService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping(path = {"/car"})
public class CarController implements BaseRestController<CarDTO, Long>{

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @Override
    @GetMapping
    public ResponseEntity<Collection<CarDTO>> readAll() {
        System.out.println("hello");
        return ResponseEntity.ok(this.carService.readAll()
                .map(CarDTO::toDTO)
                .toList());
    }

    @Override
    @GetMapping(path = {"/id:[0-9]+"})
    public ResponseEntity<CarDTO> readOne(Long id) {

        Car car = this.carService.readOneByKey(id).orElseThrow(() -> new HttpNotFoundException("car with id (" + id + ") doesn't exist"));

        return ResponseEntity.ok(CarDTO.toDTO(car));
    }

    @PostMapping(path = {"/add"})
    public ResponseEntity<CarDTO> addCar( @Valid @RequestBody CarAddForm carAddForm ){
        System.out.println(carAddForm);
        Car car = new Car();
        try {
            car = this.carService.save(carAddForm.toBLL());
        }catch (Exception exception){
            throw new HttpPreconditionFailedException(exception.getMessage(), new ArrayList<>());
        }
        return ResponseEntity.ok(CarDTO.toDTO(car));
    }
}

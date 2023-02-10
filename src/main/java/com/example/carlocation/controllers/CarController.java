package com.example.carlocation.controllers;

import com.example.carlocation.exceptions.HttpNotFoundException;
import com.example.carlocation.exceptions.HttpPreconditionFailedException;
import com.example.carlocation.models.Period;
import com.example.carlocation.models.dtos.car.CarDTO;
import com.example.carlocation.models.entities.Car;
import com.example.carlocation.models.forms.CarAddForm;
import com.example.carlocation.services.car.CarService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = {"/car"})
public class CarController{

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<CarDTO> readOne(@PathVariable Long id) {

        Car car = this.carService.readOneByKey(id).orElseThrow(() -> new HttpNotFoundException("car with id (" + id + ") doesn't exist"));

        return ResponseEntity.ok(CarDTO.toDTO(car));
    }
    @GetMapping(path = {""})
    public ResponseEntity<Collection<CarDTO>> readAll(
            Period period
    ){
        if (period != null) {
            return ResponseEntity.ok(this.carService.getCarsByAvailable(period.start(), period.end()).stream().map(CarDTO::toDTO).toList());
        }
        return ResponseEntity.ok(this.carService.readAll()
                .map(CarDTO::toDTO)
                .toList());
    }

    @GetMapping(path = "/{id}/invalidPeriod")
    public ResponseEntity<List<Period>> getNotAvailable(@PathVariable Long id){
        Car car = this.carService.readOneByKey(id).orElseThrow(() -> new HttpNotFoundException("There is no car with id:(" + id + ")"));

        return ResponseEntity.ok(CarDTO.toDTO(car).getNotAvailable());
    }

    @PostMapping(path = {"/add"})
    public ResponseEntity<CarDTO> addCar( @Valid @RequestBody CarAddForm carAddForm ){
        if (!carAddForm.isRepair()) {
            carAddForm.setReturnDate(null);
        }
        Car car = new Car();
        try {
            car = this.carService.save(carAddForm.toBLL());
        }catch (Exception exception){
            throw new HttpPreconditionFailedException(exception.getMessage(), new ArrayList<>());
        }
        return ResponseEntity.ok(CarDTO.toDTO(car));
    }
}

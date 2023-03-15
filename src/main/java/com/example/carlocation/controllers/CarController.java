package com.example.carlocation.controllers;

import com.example.carlocation.exceptions.HttpNotFoundException;
import com.example.carlocation.exceptions.HttpPreconditionFailedException;
import com.example.carlocation.models.Period;
import com.example.carlocation.models.dtos.car.CarDTO;
import com.example.carlocation.models.dtos.option.OptionDTO;
import com.example.carlocation.models.entities.Car;
import com.example.carlocation.models.entities.Option;
import com.example.carlocation.models.forms.CarAddForm;
import com.example.carlocation.services.car.CarService;
import com.example.carlocation.services.model.ModelService;
import com.example.carlocation.services.pricingClass.PricingClassService;
import com.example.carlocation.services.reservation.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = {"/cars"})
@CrossOrigin(origins = "http://localhost:4200")
public class CarController{

    private final CarService carService;

    private final ReservationService reservationService;

    private final PricingClassService pricingClassService;

    public CarController(CarService carService, ReservationService reservationService, PricingClassService pricingClassService) {
        this.carService = carService;
        this.reservationService = reservationService;
        this.pricingClassService = pricingClassService;
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

        CarDTO carDTO = CarDTO.toDTO(car);
        carDTO.setNotAvailable(reservationService.findAllByCar(car)
                .stream()
                .map(it -> new Period(it.getRemoval(), it.getRestitution()))
                .toList());

        return ResponseEntity.ok(carDTO.getNotAvailable());
    }

    @PostMapping(path = "")
    public ResponseEntity<CarDTO> addCar( @RequestBody CarAddForm carAddForm ){
        if (carAddForm.isRepair()) {
            carAddForm.setReturnDate(null);
        }
        Car car = carAddForm.toBLL();
//        List<Option> options = car.getModel().getOptions().stream().map(it -> this.optionService.findByName(it.getOptionName())).toList();
//        car.getModel().setOptions(options);
//        car.getModel().setPricingClass(this.pricingClassService
//                .readOneByKey(carAddForm.getModel().getPricingClassId())
//                .orElseThrow( () -> new HttpNotFoundException("There is no pricing class with the id : " + carAddForm.getModel().getPricingClassId())));


        this.carService.save(car);
        return ResponseEntity.ok(CarDTO.toDTO(car));
    }

    @PutMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<CarDTO> updateOne(@PathVariable Long id, @Valid @RequestBody CarAddForm form){
        Car car = this.carService.readOneByKey(id).orElseThrow( () -> new HttpNotFoundException("There is no car with id:(" + id + ")"));

        car.setRepair(form.isRepair());
        car.setKm(form.getKm());
        car.setReturnDate(form.getReturnDate());
        car.setBuyDate(form.getBuyDate());
        car.setBuyPrice(form.getBuyPrice());
        car.setSupplier(form.getSupplier());
        car.setUpdatedAt(LocalDate.now());


            this.carService.save(car);

        return ResponseEntity.ok(CarDTO.toDTO(car));
    }

}

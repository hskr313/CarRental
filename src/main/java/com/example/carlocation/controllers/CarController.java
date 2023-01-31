package com.example.carlocation.controllers;

import com.example.carlocation.exceptions.HttpNotFoundException;
import com.example.carlocation.models.dtos.car.CarDTO;
import com.example.carlocation.models.entities.Car;
import com.example.carlocation.services.car.CarService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = {"/car"})
public class CarController implements BaseRestController<Car, Long>{

}

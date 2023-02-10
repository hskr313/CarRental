package com.example.carlocation.models.dtos.car;

import com.example.carlocation.models.Period;
import com.example.carlocation.models.dtos.model.ModelDTO;
import com.example.carlocation.models.entities.Car;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CarDTO {

    private Long id;

    private int buyPrice;

    private LocalDate buyDate;

    private Long km;

    private String supplier;

    private boolean repair = false;

    private LocalDate returnDate;

    private ModelDTO model;

    private List<Period> notAvailable = new ArrayList<>();


    public static CarDTO toDTO(Car car){

        CarDTOBuilder dto = CarDTO.builder();

        return dto
                .id(car.getId())
                .buyPrice(car.getBuyPrice())
                .buyDate(car.getBuyDate())
                .km(car.getKm())
                .supplier(car.getSupplier())
                .repair(car.isRepair())
                .returnDate(car.getReturnDate())
                .model(ModelDTO.toDTO(car.getModel()))
                .build();

    }
}

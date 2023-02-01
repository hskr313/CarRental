package com.example.carlocation.models.forms.car;

import com.example.carlocation.models.dtos.model.ModelDTO;
import com.example.carlocation.models.entities.Car;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@ToString
public class CarAddForm {

    // @NotBlank(message = "Must be not blank")
    private int buyPrice;
//    @NotEmpty
    private LocalDate buyDate;
//    @PositiveOrZero
    private Long km;
//    @NotBlank(message = "Must be not blank")
    private String supplier;

    private boolean repair = false;

    private LocalDate returnDate;

    private ModelAddForm model;

    public Car toBLL(){
        return Car.builder()
                .buyPrice(buyPrice)
                .buyDate(buyDate)
                .km(km)
                .supplier(supplier)
                .repair(repair)
                .returnDate(returnDate)
                .model(model.toBLL())
                .build();
    }
}

package com.example.carlocation.models.dtos.car;

import com.example.carlocation.models.dtos.model.ModelDTO;
import com.example.carlocation.models.dtos.reservation.ReservationDTO;
import com.example.carlocation.models.entities.Car;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
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

    private List<ReservationDTO> reservations;

    public CarDTO toDTO(Car car){

        return CarDTO.builder()
                .id(car.getId())
                .buyPrice(car.getBuyPrice())
                .buyDate(car.getBuyDate())
                .km(car.getKm())
                .supplier(car.getSupplier())
                .repair(car.isRepair())
                .returnDate(car.getReturnDate())
                .model(ModelDTO.toDTO(car.getModel()))
                .reservations(car.getReservations().stream()
                        .map(ReservationDTO::toDTO)
                        .toList())
                .build();

    }

}

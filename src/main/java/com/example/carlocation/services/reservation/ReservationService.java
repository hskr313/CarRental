package com.example.carlocation.services.reservation;

import com.example.carlocation.models.entities.Car;
import com.example.carlocation.models.entities.Customer;
import com.example.carlocation.models.entities.Reservation;
import com.example.carlocation.services.CrudService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationService extends CrudService<Reservation, Long> {
    void ending(Reservation reservation);

    void cancellation(Reservation reservation);

    void deletion(Reservation reservation);

    List<Reservation> findAllByCar(Car car);

    List<Reservation> findAllByCustomer(Customer customer);
}

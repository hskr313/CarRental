package com.example.carlocation.services.reservation;

import com.example.carlocation.models.entities.Reservation;
import com.example.carlocation.services.CrudService;

public interface ReservationService extends CrudService<Reservation, Long> {
    void restitution(Reservation reservation);

    void cancellation(Reservation reservation);

    void deletion(Reservation reservation);
}

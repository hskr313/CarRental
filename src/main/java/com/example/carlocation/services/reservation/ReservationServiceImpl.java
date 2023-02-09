package com.example.carlocation.services.reservation;

import com.example.carlocation.models.entities.Reservation;
import com.example.carlocation.models.entities.ReservationStatus;
import com.example.carlocation.repositories.ReservationRepository;
import com.example.carlocation.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl extends CrudServiceImpl<ReservationRepository, Reservation, Long>
        implements ReservationService {

    public ReservationServiceImpl(ReservationRepository repository) {
        super(repository);
    }

    private void changeStatus(Reservation reservation, ReservationStatus newStatus) {
        if (reservation.getReservStatus().next(newStatus, reservation)) {
            this.repository.save(reservation);
        }
    }

    public void restitution(Reservation reservation) {
        this.changeStatus(reservation, ReservationStatus.finished);
    }

    public void cancellation(Reservation reservation) {
        this.changeStatus(reservation, ReservationStatus.canceled);
    }

    public void deletion(Reservation reservation) {
        this.changeStatus(reservation, ReservationStatus.deleted);
    }
}

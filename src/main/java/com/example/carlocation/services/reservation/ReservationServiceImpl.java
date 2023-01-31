package com.example.carlocation.services.reservation;

import com.example.carlocation.models.entities.Reservation;
import com.example.carlocation.repositories.ReservationRepository;
import com.example.carlocation.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl extends CrudServiceImpl<ReservationRepository, Reservation, Long>
        implements ReservationService {

    public ReservationServiceImpl(ReservationRepository repository) {
        super(repository);
    }
}

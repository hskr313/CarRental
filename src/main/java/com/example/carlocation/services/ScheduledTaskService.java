package com.example.carlocation.services;

import com.example.carlocation.repositories.ReservationRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.stream.Collectors;

@Service
public class ScheduledTaskService {

    private final ReservationRepository reservationRepository;

    public ScheduledTaskService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Scheduled(cron = "0 0 1 * *")
    public void deleteReservations(){

        this.reservationRepository.deleteAll(this.reservationRepository.findAll()
                .stream()
                .filter( reservation -> Period.between(reservation.getClosingDate(), LocalDate.now()).getMonths() >= 6)
                .collect(Collectors.toList()));

    }
}

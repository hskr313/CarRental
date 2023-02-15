package com.example.carlocation.services.reservation;

import com.example.carlocation.models.entities.Car;
import com.example.carlocation.models.entities.Customer;
import com.example.carlocation.models.entities.Reservation;
import com.example.carlocation.models.entities.ReservationStatus;
import com.example.carlocation.repositories.CarRepository;
import com.example.carlocation.repositories.ReservationRepository;
import com.example.carlocation.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.List;

@Service
public class ReservationServiceImpl extends CrudServiceImpl<ReservationRepository, Reservation, Long>
        implements ReservationService {

    private final CarRepository carRepository;

    public ReservationServiceImpl(ReservationRepository repository, CarRepository carRepository) {
        super(repository);
        this.carRepository = carRepository;
    }

    private void changeStatus(Reservation reservation, ReservationStatus newStatus) {
        if (reservation.getReservStatus().next(newStatus, reservation)) {
            this.repository.save(reservation);
        }
    }

    public void ending(Reservation reservation) {
        this.changeStatus(reservation, ReservationStatus.finished);
    }

    public void cancellation(Reservation reservation) {
        this.changeStatus(reservation, ReservationStatus.canceled);
    }

    public void deletion(Reservation reservation) {
        Period period = Period.between(reservation.getCancellationDate(), reservation.getRemoval());
        if ( period.getDays() < 2 ) {
            reservation.setFinDeleted(this.carRepository.getIndicativePriceByPricingAndFormula(
                    reservation.getCar().getId(),
                    reservation.getCar().getModel().getPricingClass().getId(),
                    reservation.getRentalFormula().getId()
            ) * 0.2
            );
        this.changeStatus(reservation, ReservationStatus.deleted);
        } else {
            this.changeStatus(reservation, ReservationStatus.finished);
        }
    }

    public List<Reservation> findAllByCar(Car car){
        return this.repository.findAllByCar(car);
    }

    public List<Reservation> findAllByCustomer(Customer customer){
        return this.repository.findAllByCustomer(customer);
    }
}

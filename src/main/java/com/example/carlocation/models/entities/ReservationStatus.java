package com.example.carlocation.models.entities;

import java.util.function.Predicate;

public enum ReservationStatus {
    effective((status) -> switch (status.ordinal()) {
        case 1, 2, 3 -> true;
        default -> false;
    }),
    deleted((status) -> switch (status.ordinal()){
        case 3 -> true;
        default -> false;
    }),
    canceled((status) -> switch (status.ordinal()){
        case 2 -> true;
        default -> false;
    }),
    finished((status) -> false);

    ReservationStatus(Predicate<ReservationStatus> acceptedTransition) {
        this.acceptedTransition = acceptedTransition;
    }

    private final Predicate<ReservationStatus> acceptedTransition;

    public boolean next(ReservationStatus newStatus, Reservation reservation) {
        if (!this.acceptedTransition.test(newStatus)) return false;

        switch (newStatus) {
            case deleted -> reservation.delete();
            case canceled -> reservation.cancel();
            case finished -> reservation.finish();
        }

        reservation.setReservStatus(newStatus);
        return true;
    }
}

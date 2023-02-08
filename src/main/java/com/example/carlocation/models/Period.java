package com.example.carlocation.models;

import java.time.LocalDate;

public record Period(
        LocalDate start,
        LocalDate end
) {

    public boolean isOverlap(Period period) {
        if (period.end.isAfter(this.start)) return true;
        if (period.start.isBefore(this.end)) return true;
        if (period.start.isAfter(this.start) && period.end.isBefore(this.end)) return true;
        return false;
    }
}

package org.example.domain.pricing;

import org.example.domain.trip.trip;
import java.time.Duration;

public class timebasedpricing implements pricingstrategy {
    private final double priceperminute;

    public timebasedpricing(double priceperminute) {
        this.priceperminute = priceperminute;
    }

    @Override
    public double calculateprice(trip trip) {
        long minutes = trip.getdurationminutes();
        return minutes * priceperminute;
    }
}
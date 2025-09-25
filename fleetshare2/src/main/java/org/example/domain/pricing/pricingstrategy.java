package org.example.domain.pricing;

import org.example.domain.trip.trip;

public interface pricingstrategy {
    double calculateprice(trip trip);
}
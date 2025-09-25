package org.example.domain.pricing;

import org.example.domain.trip.trip;

public class distancebasedpricing implements pricingstrategy {
    private final double priceperkm;

    public distancebasedpricing(double priceperkm) {
        this.priceperkm = priceperkm;
    }

    @Override
    public double calculateprice(trip trip) {
        return trip.getdistancekm() * priceperkm;
    }
}
package org.example.domain.pricing;

import org.example.domain.trip.trip;

public class hybridpricing implements pricingstrategy {
    private final double priceperminute;
    private final double priceperkm;

    public hybridpricing(double priceperminute, double priceperkm) {
        this.priceperminute = priceperminute;
        this.priceperkm = priceperkm;
    }

    @Override
    public double calculateprice(trip trip) {
        double timecost = trip.getdurationminutes() * priceperminute;
        double distancecost = trip.getdistancekm() * priceperkm;
        return timecost + distancecost;
    }
}
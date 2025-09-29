package org.example.domain.pricing;

import org.example.domain.trip.trip;
import java.time.Duration;


public class timebasedpricing implements pricingstrategy {
    private final double priceperminute;


    public timebasedpricing(double priceperminute) {
        if (priceperminute <= 0) {
        throw new IllegalArgumentException("priceperminute must be greater than 0");}
        this.priceperminute = priceperminute;
    }


    @Override
    public double calculateprice(trip trip) {
        long minutes = trip.getdurationminutes();

        double cost =minutes * priceperminute;

        System.out.println("time based pricing:"+minutes+"min x $"+priceperminute+"=$"+cost);
                return cost;
    }


    public double getpriceperminute() {
        return priceperminute;
    }
    public String getdescription(){
        return String.format("time-based pricing %.2f per min", priceperminute);
    }
}
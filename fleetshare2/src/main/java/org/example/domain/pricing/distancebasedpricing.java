package org.example.domain.pricing;

import org.example.domain.trip.trip;


public class distancebasedpricing implements pricingstrategy {
    private final double priceperkm;

    public distancebasedpricing(double priceperkm) {
        if (priceperkm <= 0) {
            throw new IllegalArgumentException("priceperkm must be greater than 0.");
        }
        this.priceperkm = priceperkm;
    }


    @Override
    public double calculateprice(trip trip) {
        double distance = trip.getdistancekm();
        double cost =distance * priceperkm;
        System.out.println("distance based pricing:"+distance+"min x $"+priceperkm+"=$"+cost);
        return cost;
    }

    public double getpriceperkm() {
        return priceperkm;
    }
    public String getdescription(){
        return String.format("distance based priceing %.2f per km",priceperkm);

    }
}
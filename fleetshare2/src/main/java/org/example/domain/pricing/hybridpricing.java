package org.example.domain.pricing;

import org.example.domain.trip.trip;


public class hybridpricing implements pricingstrategy {
    private final double priceperminute;
    private final double priceperkm;

    public hybridpricing(double priceperminute, double priceperkm) {

        if (priceperminute<=0||priceperkm<=0) {
         throw new IllegalArgumentException("price must be greater than zero");
        }
        this.priceperminute = priceperminute;
        this.priceperkm = priceperkm;
    }


    @Override
    public double calculateprice(trip trip) {

        long minutes = trip.getdurationminutes();
        double distance =trip.getdistancekm();

        double timecost = trip.getdurationminutes() * priceperminute;
        double distancecost = trip.getdistancekm() * priceperkm;
        double totalcost= timecost + distancecost;
        System.out.println("Hyprid pricing( "+minutes+"min x $"+priceperminute+")+("+distance+"km x $"+priceperkm+")=$"+ totalcost);
     return totalcost;
    }


    public double getpriceperminute() {
        return priceperminute;
    }

    public double getpriceperkm() {
        return priceperkm;
    }
    public String getdescription(){
        return String.format("Hybrid priceing $%.2f per min + $%.2f per km",priceperminute,priceperkm);

    }
}
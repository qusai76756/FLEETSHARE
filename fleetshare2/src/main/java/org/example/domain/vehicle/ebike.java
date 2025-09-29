package org.example.domain.vehicle;

import javax.management.ConstructorParameters;

public class ebike extends vehicle {
    private final int maxbatteryrange;
     private int currentbatterylevel;

    public ebike(String id, String model, double basepriceperminute, int maxbatteryrange) {
        super(id, model, vehicletype.e_bike, basepriceperminute);
        this.maxbatteryrange = maxbatteryrange;
        this.currentbatterylevel=100;

    }
    public int getMaxbatteryrange() {
        return maxbatteryrange;
    }
    public int getCurrentbatterylevel() {
        return currentbatterylevel;
    }



    public void chargebattery(){
        this.currentbatterylevel=100;

    }



    public void usebattery(int amount)
    {
        if (amount>0){
            this.currentbatterylevel -=amount;
            if(currentbatterylevel<0){
                currentbatterylevel=0;
            }

        }

    }

    public void chargebattery(int percentage){
        if (percentage>= 0 && percentage <= 100){
            this.currentbatterylevel=percentage;
            System .out.println("chargebattery "+percentage+"%");
        }
    }
    public boolean isbatterylow()
    {return currentbatterylevel<20;}

    @Override
    public String getdescription() {
        String batterystatus= isbatterylow()?"low":"high";
        return String.format("ebike: %s (%d km range ,%d %battery -%s )"
        , getmodel(), maxbatteryrange, currentbatterylevel, batterystatus);
    }
}
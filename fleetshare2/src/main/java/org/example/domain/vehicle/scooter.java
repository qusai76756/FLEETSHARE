package org.example.domain.vehicle;

public class scooter extends vehicle {
    private final int maxspeed;

    public scooter(String id, String model, double basepriceperminute, int maxspeed) {
        super(id, model, vehicletype.scooter, basepriceperminute);
        this.maxspeed = maxspeed;
    }

    public int getmaxspeed() { return maxspeed; }

    @Override
    public String getdescription() {
        return String.format("scooter: %s (%d km/h)", getmodel(), maxspeed);
    }
}
package org.example.domain.vehicle;

public class car extends vehicle {
    private final int seats;
    private final String fueltype;

    public car(String id, String model, double basepriceperminute, int seats, String fueltype) {
        super(id, model, vehicletype.car, basepriceperminute);
        this.seats = seats;
        this.fueltype = fueltype;
    }

    public int getseats() { return seats; }
    public String getfueltype() { return fueltype; }

    @Override
    public String getdescription() {
        return String.format("car: %s (%d seats, %s)", getmodel(), seats, fueltype);
    }
}
package org.example.domain.vehicle;

public abstract class vehicle {

    private final String id;
    private final String model;
    private final vehicletype type;
    private vehiclestate state;
    private double basepriceperminute;

    public vehicle(String id, String model, vehicletype type, double basepriceperminute) {
        this.id = id;
        this.model = model;
        this.type = type;
        this.basepriceperminute = basepriceperminute;
        this.state = vehiclestate.available;
    }

    // getters
    public String getid() {
        return id;
    }

    public String getmodel() {
        return model;
    }

    public vehicletype gettype() {
        return type;
    }

    public double getbaseperminute() {
        return basepriceperminute;
    }

    // domain methods
public void markasavailable() {
    this.state = vehiclestate.available;}
public void markasinuse(){
    this.state=vehiclestate.in_use;
    }

    public void markformaintenance(){this.state=vehiclestate.maintenance;}
public boolean isavailable() { return state==vehiclestate.available;}

public abstract String getdescription();
}

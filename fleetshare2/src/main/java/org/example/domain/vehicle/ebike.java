package org.example.domain.vehicle;

public class ebike extends vehicle {
    private final int batteryrange; // in km

    public ebike(String id, String model, double basepriceperminute, int batteryrange) {
        super(id, model, vehicletype.e_bike, basepriceperminute);
        this.batteryrange = batteryrange;
    }

    public int getbatteryrange() { return batteryrange; }

    @Override
    public String getdescription() {
        return String.format("ebike: %s (%d km range)", getmodel(), batteryrange);
    }
}
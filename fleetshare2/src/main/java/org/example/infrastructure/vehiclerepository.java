package org.example.infrastructure;

import org.example.domain.vehicle.vehicle;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class vehiclerepository {
    private final List<vehicle> vehicles = new ArrayList<>();


    public void save(vehicle vehicle) {
        vehicles.add(vehicle);
    }


    public Optional<vehicle> findbyid(String id) {
        for (vehicle v : vehicles) {
            if (v.getid().equals(id)) {
                return Optional.of(v);
            }
        }
        return Optional.empty();
    }


    public List<vehicle> findavailable() {
        List<vehicle> available = new ArrayList<>();
        for (vehicle v : vehicles) {
            if (v.isavailable()) {
                available.add(v);
            }
        }
        return available;
    }


    public List<vehicle> findall() {
        return new ArrayList<>(vehicles);
    }


    public int count() {
        return vehicles.size();
    }
}
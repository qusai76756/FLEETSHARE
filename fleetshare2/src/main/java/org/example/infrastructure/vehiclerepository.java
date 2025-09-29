package org.example.infrastructure;

import org.example.domain.vehicle.vehicle;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class vehiclerepository {
    // نخزن المركبات في قائمة - in-memory storage
    private final List<vehicle> vehicles = new ArrayList<>();


    public void save(vehicle vehicle) {
        if (vehicle != null) {
            vehicles.add(vehicle);
            System.out.println("vehicle has been saved"+vehicle.getid()+"-"+vehicle.getmodel());
        }

    }


    public Optional<vehicle> findbyid(String id) {
        for (vehicle vehicle : vehicles) {
            if (vehicle.getid().equals(id)) {
                return Optional.of(vehicle);  // وجدنا المركبة
            }
        }
        return Optional.empty();  // ما حصلنا على المركبة
    }


    public List<vehicle> findavailable() {
        List<vehicle> availablevechels = new ArrayList<>();
        for (vehicle vehicle : vehicles) {
            if (vehicle.isavailable()) {
                availablevechels.add(vehicle);
            }
        }
        return availablevechels;
    }


    public List<vehicle> findall() {
        return new ArrayList<>(vehicles);  // نرجع نسخة عشان encapsulation
    }


    public int count() {
        return vehicles.size();
    }


    public boolean deletebyid(String id) {
        return vehicles.removeIf(v -> v.getid().equals(id));
    }
    public boolean updatevehicle(vehicle updatevehicle) {
        for(int i=0;i<vehicles.size();i++){
            if(vehicles.get(i).getid().equals(updatevehicle.getid())){
                vehicles.set(i,updatevehicle);
                return true;
            }
        }


        return false;
    }

}
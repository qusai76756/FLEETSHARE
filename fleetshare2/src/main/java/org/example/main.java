package org.example;

import org.example.infrastructure.vehiclerepository;
import org.example.domain.vehicle.car;
import org.example.domain.vehicle.ebike;
import org.example.domain.vehicle.scooter;
import org.example.domain.vehicle.vehicle;
import java.util.Optional;

public class main {
    public static void main(String[] args) {
        System.out.println(" Testing Repository Pattern...");


        vehiclerepository repo = new vehiclerepository();


        repo.save(new car("car001", "toyota camry", 0.5, 5, "gasoline"));
        repo.save(new ebike("bike001", "superbike", 0.2, 50));
        repo.save(new scooter("scooter001", "fast scooter", 0.1, 25));


        System.out.println("total vehicles: " + repo.count());
        System.out.println("available vehicles: " + repo.findavailable().size());


        Optional<vehicle> foundcar = repo.findbyid("car001");
        if (foundcar.isPresent()) {
            System.out.println("found car: " + foundcar.get().getdescription());
        }


        System.out.println("all vehicles:");
        for (vehicle v : repo.findall()) {
            System.out.println(" - " + v.getdescription());
        }

        System.out.println("Repository pattern working!");
    }
}
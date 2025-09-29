package org.example.application;

import org.example.domain.User.User;
import org.example.domain.vehicle.*;
import org.example.infrastructure.vehiclerepository;

import java.util.List;
import java.util.Scanner;

public class ConsoleService {
    private final Scanner scanner;
    private final vehiclerepository vehicleRepo;
    private User currentUser;

    public ConsoleService() {
        this.scanner = new Scanner(System.in);
        this.vehicleRepo = new vehiclerepository();
        initializeData();
    }

    /**
     *  start: بدء النظام التفاعلي
     */
    public void start() {
        System.out.println(" Welcome to FleetShare System!");
        showMainMenu();
    }

    /**
     * 📋 showMainMenu:
     */
    private void showMainMenu() {
        while (true) {
            System.out.println("\n===  Main Menu ===");
            System.out.println("1.  User Registration");
            System.out.println("2.  View Available Vehicles");
            System.out.println("3. 🛣 Start New Trip");
            System.out.println("4.  Check Trip Cost");
            System.out.println("5. Upgrade Membership");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = getIntInput();
            handleMainMenuChoice(choice);
        }
    }

    /**
     * 🎯 handleMainMenuChoice: معالجة اختيار القائمة الرئيسية
     */
    private void handleMainMenuChoice(int choice) {
        switch (choice) {
            case 1 -> registerUser();
            case 2 -> showAvailableVehicles();
            case 3 -> startNewTrip();
            case 4 -> checkTripCost();
            case 5 -> upgradeMembership();
            case 6 -> exitProgram();
            default -> System.out.println(" Invalid choice! Try again.");
        }
    }

    /**

     */
    private void registerUser() {
        System.out.println("\n=== User Registration ===");

        System.out.print("Enter username: ");
        String username = scanner.next();

        System.out.print("Enter email: ");
        String email = scanner.next();

        System.out.print("Enter initial balance: ");
        double balance = getDoubleInput();

        String userId = "user_" + System.currentTimeMillis();
        currentUser = new User(userId, username, email, balance);

        System.out.println(" User registered successfully!");
        System.out.println(" " + currentUser.getuserinfo());
    }

    /**

     */
    private void showAvailableVehicles() {
        System.out.println("\n===  Available Vehicles ===");

        List<vehicle> availableVehicles = vehicleRepo.findavailable();

        if (availableVehicles.isEmpty()) {
            System.out.println(" No vehicles available at the moment.");
            return;
        }

        System.out.println("Found " + availableVehicles.size() + " available vehicles:");
        for (int i = 0; i < availableVehicles.size(); i++) {
            vehicle vehicle = availableVehicles.get(i);
            System.out.println((i + 1) + ". " + vehicle.getdescription());
        }
    }

    /**
     *
     */
    private void startNewTrip() {


        if (currentUser == null) {
            System.out.println("Please register as a user first!");
            return;
        }

        System.out.println("\n=== 🛣️ Start New Trip ===");
        showAvailableVehicles();


        System.out.println("🚧 Feature coming soon...");
    }

    /**
     *
     */
    private void checkTripCost() {
        System.out.println("\n=== 💰 Check Trip Cost ===");
        System.out.println("🚧 Feature coming soon...");
    }

    /**
     *
     */
    private void upgradeMembership() {
        if (currentUser == null) {
            System.out.println("❌ Please register as a user first!");
            return;
        }

        System.out.println("\n=== 🏆 Upgrade Membership ===");
        System.out.println("🚧 Feature coming soon...");
    }

    /**

     */
    private void exitProgram() {
        System.out.println(" Thank you for using FleetShare!");
        System.exit(0);
    }

    /**
     * initializeData:
     */
    private void initializeData() {
        //
        vehicleRepo.save(new car("car_001", "Toyota Camry", 0.5, 5, "Gasoline"));
        vehicleRepo.save(new car("car_002", "Honda Civic", 0.4, 5, "Hybrid"));


        vehicleRepo.save(new ebike("bike_001", "Super Bike", 0.2, 50));
        vehicleRepo.save(new ebike("bike_002", "City Rider", 0.15, 40));


        vehicleRepo.save(new scooter("scooter_001", "Fast Scooter", 0.1, 25));
        vehicleRepo.save(new scooter("scooter_002", "Urban Glider", 0.08, 20));

        System.out.println("✅ Sample data loaded successfully!");
    }

    //
    private int getIntInput() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // clear buffer
            return -1;
        }
    }

    private double getDoubleInput() {
        try {
            return scanner.nextDouble();
        } catch (Exception e) {
            scanner.nextLine(); // clear buffer
            return -1;
        }
    }
}

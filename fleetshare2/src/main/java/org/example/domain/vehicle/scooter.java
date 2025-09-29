


package org.example.domain.vehicle;

public class scooter extends vehicle {

    // ========== ==========


    private final int maxspeed;


    private int currentbatterylevel;

    // ==========  CONSTRUCTOR ==========

    public scooter(String id, String model, double basepriceperminute, int maxspeed) {
        super(id, model, vehicletype.scooter, basepriceperminute);
        this.maxspeed = maxspeed;
        this.currentbatterylevel = 100;
    }

    // ========== 🔍 GETTERS ==========

    public int getmaxspeed() {
        return maxspeed;
    }

    public int getcurrentbatterylevel() {
        return currentbatterylevel;
    }

    // ========== 🔄 DOMAIN METHODS ==========


    public void usebattery(int amount) {
        if (amount > 0) {
            this.currentbatterylevel -= amount;
            if (currentbatterylevel < 0) {
                currentbatterylevel = 0;
            }
        }
    }


    public void chargebattery() {
        this.currentbatterylevel = 100;
        System.out.println("🔋 Scooter battery charged to 100%");
    }

    public void chargebattery(int percentage) {
        if (percentage >= 0 && percentage <= 100) {
            this.currentbatterylevel = percentage;
            System.out.println("Scooter battery charged to " + percentage + "%");
        }
    }


    public boolean isbatterylow() {
        return currentbatterylevel < 15;
    }


    public boolean isfast() {
        return maxspeed > 20;
    }

    // ==========  ABSTRACT METHOD ==========

    @Override
    public String getdescription() {
        String speedstatus = isfast() ? "⚡ Fast" : " Normal";
        String batterystatus = isbatterylow() ? " Low" : " Good";

        return String.format("scooter: %s (%d km/h, %d%% battery - %s Speed - %s Battery)",
                getmodel(), maxspeed, currentbatterylevel, speedstatus, batterystatus);
    }
}
package org.example.domain.trip;

import org.example.domain.user.user;
import org.example.domain.vehicle.vehicle;
import java.time.LocalDateTime;
import java.time.Duration;

public class trip {
    private final String tripid;
    private final user user;
    private final vehicle vehicle;
    private LocalDateTime starttime;
    private LocalDateTime endtime;
    private tripstate state;
    private double distancekm;
    private double totalcost;

    public trip(String tripid, user user, vehicle vehicle) {
        this.tripid = tripid;
        this.user = user;
        this.vehicle = vehicle;
        this.state = tripstate.active;
        this.starttime = LocalDateTime.now();
        this.distancekm = 0.0;
        this.totalcost = 0.0;
    }

    // getters
    public String gettripid() { return tripid; }
    public user getuser() { return user; }
    public vehicle getvehicle() { return vehicle; }
    public tripstate getstate() { return state; }
    public double getdistancekm() { return distancekm; }
    public double gettotalcost() { return totalcost; }

    // domain methods
    public void updatedistance(double newdistance) {
        if (state == tripstate.active && newdistance > 0) {
            this.distancekm = newdistance;
        }
    }

    public void endtrip() {
        if (state == tripstate.active) {
            this.endtime = LocalDateTime.now();
            this.state = tripstate.completed;
            calculatetotalcost();
        }
    }

    private void calculatetotalcost() {
        long minutes = Duration.between(starttime, endtime).toMinutes();
        this.totalcost = minutes * vehicle.getbasepriceperminute();
    }

    public long getdurationminutes() {
        if (endtime != null) {
            return Duration.between(starttime, endtime).toMinutes();
        }
        return Duration.between(starttime, LocalDateTime.now()).toMinutes();
    }

    public String gettripinfo() {
        return String.format("trip %s: %s using %s - cost: $%.2f",
                tripid, user.getusername(), vehicle.getmodel(), totalcost);
    }
}
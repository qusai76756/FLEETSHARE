package org.example.domain.trip;

import org.example.domain.User.User;
import org.example.domain.vehicle.vehicle;
import java.time.LocalDateTime;
import java.time.Duration;


public class trip {

    private final String tripid;
    private final User User ;

    private final vehicle vehicle;
    private final LocalDateTime starttime;
    private  LocalDateTime endtime;
    private tripstate state;
    private double distancekm;
    private double totalcost;

    public trip(String tripid, User user, vehicle vehicle) {
        this.tripid = tripid;
        this.User = user;
        this.vehicle = vehicle;
        this.state = tripstate.active;
        this.starttime = LocalDateTime.now();
        this.distancekm = 0.0;
        this.totalcost = 0.0;


        vehicle.markasinuse();
    }

    // ==========  getters ==========
    public String gettripid() { return tripid; }
    public User getuser() { return User; }
    public vehicle getvehicle() { return vehicle; }
    public tripstate getstate() { return state; }
    public double getdistancekm() { return distancekm; }
    public double gettotalcost() { return totalcost; }

    // ========== domain methods ==========


    public void updatedistance(double newdistance) {
        if (state == tripstate.active && newdistance > 0) {
            this.distancekm = newdistance;
            System.out.print("Distance update to"+newdistance+"km");
        }
    }


    public void endtrip() {
        if (state == tripstate.active) {
            this.endtime = LocalDateTime.now();
            this.state = tripstate.completed;
            calculatetotalcost();


            vehicle.markasavailable();

            System.out.println("trip"+tripid+"completed.cost:$"+totalcost);
        }
    }


    private void calculatetotalcost() {
        long minutes = getdurationminutes();
        this.totalcost = minutes * vehicle.getbaseperminute();
    }


    public long getdurationminutes() {
        if (endtime != null) {
            return Duration.between(starttime, endtime).toMinutes();
        }

        return Duration.between(starttime, LocalDateTime.now()).toMinutes();
    }
    public double getcurrentcost() {
        long minutes = getdurationminutes();
        return minutes * vehicle.getbaseperminute();
    }


   public boolean isactive() {
        return state == tripstate.active;

   }
    /**

     */
    public String gettripinfo() {
        return String.format("trip %s: %s using %s - cost: $%.2f",
                tripid, User.getusername(), vehicle.getmodel(), totalcost);
    }
    public String getelapsedtime() {
        Duration duration= Duration.between(starttime, LocalDateTime.now());
        return String.format("%d min, %d sec "
                ,duration.toMinutes(),duration.getSeconds()%60);

    }
}
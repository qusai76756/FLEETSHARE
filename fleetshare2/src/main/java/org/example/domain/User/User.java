package org.example.domain.User;


public class User {

    private final String userid;
    private final String username;
    private final String email;
    private double balance;
    private membershiptier tier;


    public User(String userid, String username, String email, double initialbalance) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.balance = initialbalance;
        this.tier = membershiptier.standard;
    }

    // ========== getters ==========
    public String getuserid() { return userid; }
    public String getusername() { return username; }
    public String getemail() { return email; }
    public double getbalance() { return balance; }
    public membershiptier gettier() { return tier; }

    // ========== اdomain methods ==========


    public void updatetier(membershiptier newtier) {
        this.tier = newtier;
    }


    public void addbalance(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }


    public boolean deductbalance(double amount) {
        if (amount > 0 && balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }


    public boolean canaffordtrip(double tripcost) {
        return balance >= tripcost;
    }


    public String getuserinfo() {
        return String.format("user: %s (%s) - balance: $%.2f - tier: %s",
                username, email, balance, tier);
    }
}
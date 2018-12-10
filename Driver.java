package com.example.jatin.joybug;

public class Driver extends User {

    private String departDate;

    Driver(String setName, String setNetid, String setDestination, String setBio, String setDepartDate) {
        super(setName, setNetid, setDestination, setBio);
        this.departDate = setDepartDate;
    }

    public String toString() {
        return ("Name: " + this.name + "\nNetid: " + this.netid + "\nDestination: " + this.destination
                + "\nBio: " + this.bio + "\nDepart Date: " + this.departDate);
    }

    public String getDepartDate() {
        return this.departDate;
    }

    public void setDepartDate(String setDepartDate) {
        this.departDate = setDepartDate;
    }
}

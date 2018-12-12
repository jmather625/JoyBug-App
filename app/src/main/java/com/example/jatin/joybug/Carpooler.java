package com.example.jatin.joybug;

public class Carpooler extends User {

    private String departDate;

    Carpooler(String setName, String setNetid, String setDestination, String setBio, String setDepartDate) {
        super(setName, setNetid, setDestination, setBio);
        this.departDate = setDepartDate;
    }

    public String getDepartDate() {
        return this.departDate;
    }

    public void setDepartDate(String setDepartDate) {
        this.departDate = setDepartDate;
    }

}

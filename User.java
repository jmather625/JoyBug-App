package com.example.jatin.joybug;

public class User {

    protected String name;
    protected String netid;
    protected String destination;
    protected String bio;

    User(String setName, String setNetid, String setDestination, String setBio) {
        this.name = setName;
        this.netid = setNetid;
        this.destination = setDestination;
        this.bio = setBio;
    }

    public String getName() {
        return this.name;
    }

    public String getNetid() {
        return this.netid;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getBio() {
        return this.bio;
    }

    public void setName(String setName) {
        this.name = setName;
    }

    public void setNetid(String setNetid) {
        this.netid = setNetid;
    }

    public void setDestination(String setDestination) {
        this.destination = setDestination;
    }

    public void setBio(String setBio) {
        this.bio = setBio;
    }

    public String toString() {
        return ("Name: " + this.name + "\nNetid: " + this.netid + "\nDestination: " + this.destination
                + "\nBio: " + this.bio);
    }

}

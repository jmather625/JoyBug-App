package com.example.jatin.joybug;

public class User {

    protected String name;
    protected String email;
    protected String destination;
    protected String bio;

    User(String setName, String setEmail, String setDestination, String setBio) {
        this.name = setName;
        this.email = setEmail;
        this.destination = setDestination;
        this.bio = setBio;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
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

    public void setEmail(String setEmail) {
        this.email = setEmail;
    }

    public void setDestination(String setDestination) {
        this.destination = setDestination;
    }

    public void setBio(String setBio) {
        this.bio = setBio;
    }

    public String toString() {
        return ("Name: " + this.name + "\nEmail: " + this.email + "\nDestination: " + this.destination
                + "\nBio: " + this.bio);
    }

}

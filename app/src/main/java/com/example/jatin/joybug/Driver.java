package com.example.jatin.joybug;

public class Driver extends User {

    private String departDate;
    private String price;
    private Driver next;

    Driver(String setName, String setEmail, String setDestination, String setBio,
           String setDepartDate, String setPrice) {
        super(setName, setEmail, setDestination, setBio);
        this.departDate = setDepartDate;
        this.price = setPrice;
    }

    public String toString() {
        return ("Name: " + this.name + "\nEmail: " + this.email + "\nDestination: " + this.destination
                + "\nBio: " + this.bio + "\nDepart Date: " + this.departDate);
    }

    public String getDepartDate() {
        return this.departDate;
    }

    public String getPrice() {return this.price;}

    public void setDepartDate(String setDepartDate) {
        this.departDate = setDepartDate;
    }

    public void setNext(Driver d) {
        this.next = d;
    }

    public Driver getNext() {
        return this.next;
    }
}

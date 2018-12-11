package com.example.jatin.joybug;

public class DriverLinkedList extends Driver {

    private DriverLinkedList next;

    DriverLinkedList(Driver d, Driver next) {
        super(d.getName(), d.getEmail(), d.getDestination(), d.getBio(), d.getDepartDate(), d.getPrice());
        this.next = new DriverLinkedList(next);
    }

    DriverLinkedList(Driver d) {
        super(d.getName(), d.getEmail(), d.getDestination(), d.getBio(), d.getDepartDate(), d.getPrice());
        this.next = null;
    }

    public DriverLinkedList getNext() {
        return next;
    }
}

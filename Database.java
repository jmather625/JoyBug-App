package com.example.jatin.joybug;
import com.google.firebase.database.*;

public class Database {

    private FirebaseDatabase database;

    Database(FirebaseDatabase setDatabase) {
        this.database = setDatabase;
    }

    public boolean addDriver(Driver setDriver) {
        try {
            String netid = setDriver.getNetid();
            String driveDate = setDriver.getDepartDate();
            this.database.getReference().child("users").child("drivers").child(netid).setValue(setDriver);
            // thinking of having two tables, one for user data one for drive data info
            this.database.getReference().child("driveData").child(driveDate).child(netid).setValue(setDriver);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addCarpooler(Carpooler setCarpooler) {
        try {
            String netid = setCarpooler.getNetid();
            this.database.getReference().child("users").child("carpoolers").child(netid).setValue(setCarpooler);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String[] findDriver(String findNetid) {
        try {
            String netid = findNetid;
            DatabaseReference ref = this.database.getReference().child("users").child("drivers").child(netid);
            String name = ref.child("name").getKey();
            String destination = ref.child("destination").getKey();
            String bio = ref.child("bio").getKey();
            String departDate = ref.child("departDate").getKey();
            String[] output = {netid, name, destination, bio, departDate};
            return output;
        } catch (Exception e) {
            String[] output = {e.getMessage()};
            return output;
        }
    }

    public String[] findCarpooler(String findNetid) {
        try {
            String netid = findNetid;
            DatabaseReference ref = this.database.getReference().child("users").child("drivers").child(netid);
            String name = ref.child("name").getKey();
            String destination = ref.child("destination").getKey();
            String bio = ref.child("bio").getKey();
            String departDate = ref.child("departDate").getKey();
            String[] output = {netid, name, destination, bio, departDate};
            return output;
        } catch (Exception e) {
            String[] output = {e.getMessage()};
            return output;
        }
    }

    public String[] findDriveDate(String findDriveDate) {

        try {
            DatabaseReference ref = this.database.getReference().child("findDriveData")
                    .child(findDriveDate);
            String name = ref.child("name").getKey();
            String netid = ref.child("netid").getKey();
            String destination = ref.child("destination").getKey();
            String bio = ref.child("bio").getKey();
            String departDate = ref.child("departDate").getKey();
            String[] output = {netid, name, destination, bio, departDate};
            return output;
        } catch (Exception e) {
            String[] output = {e.getMessage()};
            return output;
        }

    }


}

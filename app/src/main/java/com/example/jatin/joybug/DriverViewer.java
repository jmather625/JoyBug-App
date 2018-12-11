package com.example.jatin.joybug;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;


public class DriverViewer extends AppCompatActivity {

    private static int calls = 0;
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    private String price;
    private String name;
    private String dest;
    private String bio;
    private String email;
    private String departDate;
    private Driver current;
    List<Driver> driverList = new ArrayList<>();

//most needing integration
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = FirebaseDatabase.getInstance();
        try {
            //"driveData/destination/jatin mathur25@gmail com"
            myRef = database.getReference("driveData/12-12-2018/");
            Log.d("SUCCESS", "right key");
        } catch (Exception e) {
            Log.d("ERROR 1", e.getMessage());
        }

        ValueEventListener test = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Log.d("START", "starting snapshot stuff");

//                List<Driver> driverList = new ArrayList<>();

                for (DataSnapshot subSnapshot : dataSnapshot.getChildren()) {
                    try {
                        int iterator = 0;
                        for (DataSnapshot dsUser : subSnapshot.getChildren()) {
                            Log.d("TAG", ((Object) dsUser.getValue(String.class)).toString());
//                            for (DataSnapshot ds : dsUser.getChildren()) {
                            try {
                                String data = ((Object) dsUser.getValue(String.class)).toString();
                                Log.d("DATA", data);
                                if (iterator == 0) {
                                    bio = data;
                                } else if (iterator == 1) {
                                    dest = data;
                                } else if (iterator == 2) {
                                    departDate = data;
                                } else if (iterator == 3) {
                                    email = data.replace(' ', '.');
                                } else if (iterator == 4) {
                                    name = data;
                                } else {
                                    price = data;
                                }
                                iterator += 1;
                            } catch (Exception e) {
                                Log.d("ERROR 2", e.getMessage());
                            }
                        }
                        Log.d("NETDATA", name + email + dest + bio + departDate + price);
                        Driver newDriver = new Driver(name, email, dest, bio, departDate, price);
                        driverList.add(newDriver);
                        String s = Arrays.toString(driverList.toArray());
                        Log.d("NETARRAY", s);
                    } catch (Exception e) {
                        Log.d("ERROR 3", e.getMessage());
                        e.printStackTrace();
                    }
                    for (int i = 0; i < driverList.size(); i++) {
                        if (i == driverList.size() - 1) {
                            driverList.get(i).setNext(driverList.get(0));
                            } else {
                                driverList.get(i).setNext(driverList.get(i + 1));
                            }
                        }

                        // start with the zeroth
                    current = driverList.get(0);
                    displayDetails(current);
                }
            }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            Log.d("ERROR OVERALL", databaseError.getMessage());
            }
        };


        myRef.addValueEventListener(test);

        setContentView(R.layout.activity_driver_viewer);

        //n
        Button nextButton = (Button) findViewById(R.id.button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayDetails(current.getNext());
                Log.d("TAG1", "ok");
                current = current.getNext();
            }
        });
    }

    public void displayDetails(Driver d) {

        setContentView(R.layout.activity_driver_viewer);

        TextView priceView = (TextView) findViewById(R.id.priceText);
        priceView.setText(d.getPrice());

        TextView nameView = (TextView) findViewById(R.id.nameText);
        nameView.setText(d.getName());

        TextView destView = (TextView) findViewById(R.id.destText);
        destView.setText(d.getDestination());

        TextView bioView = (TextView) findViewById(R.id.bioText);
        bioView.setText(d.getBio());

        TextView emailView = (TextView) findViewById(R.id.emailText);
        emailView.setText(d.getEmail());
    }
}

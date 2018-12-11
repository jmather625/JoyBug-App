package com.example.jatin.joybug;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class DriverViewer extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    private String price;
    private String name;
    private String dest;
    private String bio;
    private String email;
    private String departDate;

//most needing integration
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = FirebaseDatabase.getInstance();
        try {
            myRef = database.getReference("driveData/Desokkokotination:/jatin mathur25@gmail com");
            Log.d("SUCCESS", "right key");
        } catch (Exception e) {
            Log.d("ERROR1", e.getMessage());
        }

        ValueEventListener test = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Log.d("START", "starting snapshot stuff");

                int count = 0;
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
//                    HashMap data = (HashMap) ds.getValue();
                    try {
                        String data = ((Object) ds.getValue(String.class)).toString();
                        Log.d("DATA", data);

                        if (count == 0) {
                            departDate = data;
                        } else if (count == 1) {
                            dest = data;
                        } else if (count == 2) {
                            bio = data;
                        } else if (count == 3) {
                            email = data.replace(' ', '.');
                        } else if (count == 4) {
                            name = data;
                        } else {
                            price = data;
                        }
                        count += 1;
                    } catch(Exception e) {
                        Log.d("ERROR2", e.getMessage());
                    }
                }
                Log.d("SHOW DATA", price + name + email + bio + dest + departDate);
                Driver newDriver = new Driver(name, email, dest, bio, departDate, price);
                displayDetails(newDriver);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("ERROR", databaseError.getMessage());
            }
        };

        myRef.addValueEventListener(test);

        setContentView(R.layout.activity_driver_viewer);

        // price doesnt update overall idk why
//        Log.d("SHOW DATA", price + name + email + bio + dest + departDate);

        Button nextButton = (Button) findViewById(R.id.button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //displayDetails(driver.next());
            }
        });
    }

    public void displayDetails(Driver d) {

        setContentView(R.layout.activity_driver_viewer);

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

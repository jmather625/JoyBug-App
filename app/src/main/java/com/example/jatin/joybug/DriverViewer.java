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
        myRef = database.getReference();

        ValueEventListener test = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Log.d("START", "starting snapshot stuff");

                int count = 0;
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    HashMap data = (HashMap) ds.getValue();
                    for (Object key : data.keySet()) {
                        count += 1;
                        Log.d("SHOWING KEYS ON DVIEWER" + count, (String) key);
//                        Log.d("Data", data.get(key).toString());
                    }
                    try {
//                        HashMap drivers = (HashMap) data.get("Desokkokotination:");
//                        Log.d("DRIVER", data.get("Desokkokotination:").toString());
                        HashMap drivers = (HashMap) data.get("Desokkokotination:");
                        try {
                            String temp_email = "jatin mathur25@gmail com";
                            HashMap driver = (HashMap) drivers.get(((Object) temp_email));
                            try {
                                price = (String) driver.get(((Object) "price"));
                                name = (String) driver.get(((Object) "name"));
                                dest = (String) driver.get(((Object) "destination"));
                                bio = (String) driver.get(((Object) "bio"));
                                email = (String) driver.get(((Object) "email"));
                                departDate = (String) driver.get(((Object) "departDate"));
                                Log.d("PRICE", "Got price " + price);
                            } catch (Exception e) {
                                Log.d("Stupid error 2", e.getMessage());
                            }
                        } catch (Exception e) {
                            Log.d("Stupid error 1", e.getMessage());
                        }
                    } catch (Exception e) {
                        Log.d("Stupid error 0", e.getMessage());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("ERROR", databaseError.getMessage());
            }
        };

        myRef.addValueEventListener(test);

        setContentView(R.layout.activity_driver_viewer);

        Log.d("SHOW DATA", price + name + email + bio + dest + departDate);

        Button nextButton = (Button) findViewById(R.id.button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //displayDetails(driver.next());
            }
        });
    }

    public void displayDetails() {

        setContentView(R.layout.activity_driver_viewer);

        TextView nameView = (TextView) findViewById(R.id.nameText);
        Log.d("NAME", this.name);
        nameView.setText(this.name);

        TextView destView = (TextView) findViewById(R.id.destText);
        Log.d("DEST", this.dest);
        destView.setText(this.dest);

        TextView bioView = (TextView) findViewById(R.id.bioText);
        Log.d("BIO", this.bio);
        bioView.setText(this.bio);

        TextView emailView = (TextView) findViewById(R.id.emailText);
        Log.d("EMAIL", this.email);
        emailView.setText(this.email);
    }
}

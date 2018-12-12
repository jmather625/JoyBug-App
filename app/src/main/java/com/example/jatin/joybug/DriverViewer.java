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

import java.util.Timer;
import java.util.TimerTask;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String travelDate = MainActivity.getDate().replace("/","-");
        setCurrent(calls, travelDate);

        setContentView(R.layout.activity_driver_viewer);

        class SayHello extends TimerTask {
            public void run() {
                calls++;
                setCurrent(calls, travelDate);
            }
        }

        Timer timer = new Timer();
        timer.schedule(new SayHello(), 0, 5000);
//        Button bButton = (Button) findViewById(R.id.button);
//        bButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                calls++;
//                Log.d("TAGS", "calls:" + calls);
//            }
//        });

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

    public void setCurrent(final int count, final String setDate) {
        database = FirebaseDatabase.getInstance();
        try {
            String path = "driveData/" + setDate;
            Log.d("PATH", path);
            myRef = database.getReference(path);

            ValueEventListener test = new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    int counter = -1;
                    Driver foundDriver = null;
                    for (DataSnapshot relevantDrivers : dataSnapshot.getChildren()) {
                        Log.d("DRIVERS", ((Object) relevantDrivers.getValue()).toString());
                        counter++;
                        int numChildren = (int) dataSnapshot.getChildrenCount();
                        Log.d("DEBUG", "children:" + numChildren + "counter:" + counter);

                        if (counter == (count % numChildren)) {
                            try {
                                int iterator = 0;
                                for (DataSnapshot driverInfo : relevantDrivers.getChildren()) {
                                    Log.d("TAG", ((Object) driverInfo.getValue(String.class)).toString());
                                    try {
                                        String data = ((Object) driverInfo.getValue(String.class)).toString();
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
                                foundDriver = new Driver(name, email, dest, bio, departDate, price);
                                displayDetails(foundDriver);
                                break;
                            } catch (Exception e) {
                                Log.d("ERROR 3", e.getMessage());
                                e.printStackTrace();
                            }
                        }
                    }

                    if (foundDriver == null) {
                        Log.d("DRIVERS NONE", "no driver found");
                        Driver empty = new Driver(" ", " ", " ", " ", " ",
                                "No driver on this date");
                        displayDetails(empty);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.d("ERROR DATABASE", databaseError.getMessage());
                }
            };

            myRef.addValueEventListener(test);

        } catch (Exception e) {
            Log.d("ERROR 1", e.getMessage());
            Driver empty = new Driver(" ", " ", " ", " ", " ",
                    "No driver on this date");
            displayDetails(empty);
        }
    }
}

package com.example.jatin.joybug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.*;

import com.google.firebase.database.*;

public class PricePicker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_picker);
        Button aButton = (Button) findViewById(R.id.aButton);
        aButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.setPrice("$0");
            }
        });

        Button bButton = (Button) findViewById(R.id.bButton);
        bButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.setPrice("$5");
                openConfirmationDisplay();
            }
        });
        Button cButton = (Button) findViewById(R.id.cButton);
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.setPrice("$10");
                openConfirmationDisplay();
            }
        });
        Button dButton = (Button) findViewById(R.id.dButton);
        dButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.setPrice("$15");
                openConfirmationDisplay();
            }
        });
        Button eButton = (Button) findViewById(R.id.eButton);
        eButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.setPrice("$20");
                openConfirmationDisplay();
            }
        });
        Button fButton = (Button) findViewById(R.id.fButton);
        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.setPrice("$25");
                openConfirmationDisplay();
            }
        });

    }
    public void openConfirmationDisplay() {
        Intent intent = new Intent(this, ConfirmationDisplay.class);
        String name = MainActivity.getName();
        String email = MainActivity.getEmail().replace(".", " ");
        String bio = MainActivity.getBio();
        String departDate = MainActivity.getDate().replace("/","-");
        String destination = MainActivity.getDest();
        String price = MainActivity.getPrice();

        Driver newDriver = new Driver(name, email, destination, bio, departDate, price);
        Database d = new Database(FirebaseDatabase.getInstance());
        boolean testAdd = d.addDriver(newDriver);
        startActivity(intent);
    }
}

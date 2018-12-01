package com.example.jatin.joybug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button driveButton;
    private Button passButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        driveButton = (Button) findViewById(R.id.driveButton);
        driveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDriverActivity();
            }
        });

        passButton = (Button) findViewById(R.id.passButton);
        passButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPassengerActivity();
            }
        });
    }

    public void openDriverActivity() {
        Intent intent = new Intent(this, DriverActivity.class);
        startActivity(intent);
    }
    public void openPassengerActivity() {
        Intent intent = new Intent(this, PassengerActivity.class);
        startActivity(intent);
    }
}

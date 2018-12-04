package com.example.jatin.joybug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DriverViewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_viewer);
        //displayDetails(driver)

        Button nextButton = (Button) findViewById(R.id.button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //displayDetails(driver.next());
            }
        });
    }
    public void displayDetails(Object driver) {
        setContentView(R.layout.activity_driver_viewer);

        TextView nameView = (TextView) findViewById(R.id.nameText);
        //nameView.setText(driver.getName());

        TextView destView = (TextView) findViewById(R.id.destText);
        //destView.setText(driver.getDest());

        TextView bioView = (TextView) findViewById(R.id.bioText);
        //bioView.setText(driver.getBio());

        TextView emailView = (TextView) findViewById(R.id.emailText);
        //emailView.setText(driver.getEmail));
    }
}

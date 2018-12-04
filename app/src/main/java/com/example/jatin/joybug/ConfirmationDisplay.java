package com.example.jatin.joybug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ConfirmationDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_display);

        setContentView(R.layout.activity_confirmation_display);
        TextView textView = (TextView) findViewById(R.id.dateText);
        textView.setText(TravelInput.getCurDate());
    }
}

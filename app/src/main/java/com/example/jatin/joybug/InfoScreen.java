package com.example.jatin.joybug;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.graphics.Color.RED;

public class InfoScreen extends AppCompatActivity {
EditText mEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_screen);
        displayDetails();
        mEdit = (EditText)findViewById(R.id.editText3);
        Button nextButton = (Button) findViewById(R.id.button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bio = mEdit.getText().toString();
                if (bio.length() < 20) {
                    MainActivity.setBio(bio);
                    openTravelInput();
                } else {
                    mEdit.setHint("Please shorten bio");
                    mEdit.setHintTextColor(Color.argb(100, 255, 50, 50));
                    mEdit.setText("");
                }

            }
        });

    }
    public void displayDetails() {
        setContentView(R.layout.activity_info_screen);
        TextView nameView = (TextView) findViewById(R.id.nameText);
        nameView.setText(MainActivity.getName());
    }
    public void openTravelInput() {
        Intent intent = new Intent(this, TravelInput.class);
        startActivity(intent);
    }
}

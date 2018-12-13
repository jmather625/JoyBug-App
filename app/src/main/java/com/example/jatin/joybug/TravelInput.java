 package com.example.jatin.joybug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

 public class TravelInput extends AppCompatActivity {
     EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_input);
        mEdit = (EditText)findViewById(R.id.editText3);
        //drive button + behavior
        Button driveButton = (Button) findViewById(R.id.driveButton);
        driveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dest = mEdit.getText().toString();
                if (dest.equals("")) {
                   mEdit.setHint("Please input destination");
                } else {
                    MainActivity.setDest(dest);
                    openPricePicker();
                }
            }
        });
        //pass button + behavior
        Button passButton = (Button) findViewById(R.id.passButton);
        passButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dest = mEdit.getText().toString();
                if (dest.equals("")) {
                    mEdit.setHint("Please input destination");
                } else {
                    MainActivity.setDest(dest);
                    openDriverViewer();
                }
            }
        });
        //get + set calendar info
        CalendarView calendar = (CalendarView)findViewById(R.id.calendarView);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar c = Calendar.getInstance();
        MainActivity.setDate(sdf.format(c.getTime()));
        sdf.format(c.getTime());
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                int d = dayOfMonth;
                int m = month;
                int y = year;
                MainActivity.setDate(String.valueOf(m + 1) + "/" + String.valueOf(d) + "/" + String.valueOf(y));
            }
        });
    }
    public void openPricePicker() {
        Intent intent = new Intent(this, PricePicker.class);
        startActivity(intent);
    }
    public void openDriverViewer() {
        Intent intent = new Intent(this, DriverViewer.class);
        startActivity(intent);

    }
}

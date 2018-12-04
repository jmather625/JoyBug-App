 package com.example.jatin.joybug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

 public class TravelInput extends AppCompatActivity {
     public static String curDate;
     public static String getCurDate(){
         return curDate;
     }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_input);

        Button driveButton = (Button) findViewById(R.id.driveButton);
        driveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConfirmationDisplay();
            }
        });
        Button passButton = (Button) findViewById(R.id.driveButton);
        passButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDriverViewer();
            }
        });
        CalendarView calendar = (CalendarView)findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                int d = dayOfMonth;
                int m = month;
                int y = year;
                curDate = String.valueOf(d) + "/" + String.valueOf(m) + "/" + String.valueOf(y);
            }
        });
    }
    public void openConfirmationDisplay() {
        Intent intent = new Intent(this, ConfirmationDisplay.class);
        startActivity(intent);
    }
    public void openDriverViewer() {
        Intent intent = new Intent(this, DriverViewer.class);
        startActivity(intent);
    }
}

package com.example.classproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BarsActivity extends AppCompatActivity {

    TextView tvBarName;
    TextView tvBarHours;
    String[] Names = DataProvider.itemdescriptions;
    String[] Hours = DataProvider.itemHours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bars);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        //link varaibles to widgets
        tvBarName = findViewById(R.id.tvBarName);
        tvBarHours = findViewById(R.id.tvBarHours);

        //get intent being passed to the new activity
        Intent callingIntent = getIntent();

        if (callingIntent != null) {

            //get value passed using key from key-value pair
            int index = callingIntent.getIntExtra("index", 0);

            //change title to name at the index
            tvBarName.setText(Names[index]);

            //change the bar hours text
            tvBarHours.setText(Hours[index]);



        }//END IF check for callingIntent

    }//END main method

}//END class
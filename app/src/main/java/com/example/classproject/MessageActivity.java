package com.example.classproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MessageActivity extends AppCompatActivity {

    TextView tvFriendsName;
    String[] names = DataProvider.UserName;

    EditText etMessage;
    Button btnSend;

    TextView userMessages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_message);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/


        //link widgets to variables
        tvFriendsName = findViewById(R.id.tvFriendsName);
        etMessage = findViewById(R.id.etMessage);
        btnSend = findViewById(R.id.btnSend);
        userMessages = findViewById(R.id.UsersText);

        //get intent being passed to the new activity
        Intent callingIntent = getIntent();

        if (callingIntent != null) {

            //get value passed using key from key-value pair
            int index = callingIntent.getIntExtra("index", 0);

            //change title to name at the index
            tvFriendsName.setText(names[index]);

            //set the textview to invisible
            userMessages.setVisibility(View.INVISIBLE);

        }//END IF check for callingIntent

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //make messages visible
                userMessages.setVisibility(View.VISIBLE);

                //set messages text view as the message in edit text
                userMessages.setText(etMessage.getText().toString());

            }
        });//END ON-CLICK send

    }//END main method

}//END class
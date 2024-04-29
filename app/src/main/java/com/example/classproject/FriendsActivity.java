package com.example.classproject;

import static java.security.AccessController.getContext;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.jar.Attributes;

public class FriendsActivity extends AppCompatActivity {

    RecyclerView rvFriends;
    String[] names = DataProvider.UserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_friends);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        //link variables to widgets
        rvFriends = findViewById(R.id.recyclerFriends);

        rvFriends.setLayoutManager(new LinearLayoutManager(this));

        rvFriends.setHasFixedSize(true);

        FriendsAdapter myAdapter = new FriendsAdapter(names);

        rvFriends.setAdapter(myAdapter);




    }//END main method

}//END class friendsActivity
package com.example.classproject;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class AccountActivity extends AppCompatActivity {

    EditText etUserName;
    EditText etPassword;
    Button btnSignIn;
    TextView tvConfirm;
    ImageView ivAccount;

    String[] userName = DataProvider.UserName;
    String[] password = DataProvider.Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        btnSignIn = findViewById(R.id.btnLogin);
        tvConfirm = findViewById(R.id.tvConfirm);
        ivAccount = findViewById(R.id.ivAccount);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Make the widgets disappear
                etUserName.setVisibility(View.GONE);
                etPassword.setVisibility(View.GONE);
                btnSignIn.setVisibility(View.GONE);
                ivAccount.setVisibility(View.GONE);

                //set the text view to have text
                tvConfirm.setText("Logging in...");

                //destroy the activity
                finish();

            }
        });//END onclick listener for signin

    }//END main method

}//END class
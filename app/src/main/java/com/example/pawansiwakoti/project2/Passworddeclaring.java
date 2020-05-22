package com.example.pawansiwakoti.project2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Passworddeclaring extends AppCompatActivity {
    EditText LogInpassword;
    Button button, chpassword;
    String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passworddeclaring);


        //For loading the password
        SharedPreferences settings = getSharedPreferences("PREFS", 0);
        password = settings.getString("password", "");

        LogInpassword = (EditText)findViewById(R.id.password);
        button = (Button)findViewById(R.id.btnLogIn);
        chpassword = (Button)findViewById(R.id.btnchpassword);
        changePassword();

    }
    public void onloginClick(View v) {
        String LogIn = LogInpassword.getText().toString();

        if(LogIn.equals(password)){
            //get access to app
            Intent Homepage = new Intent(getApplicationContext(),PlayerName.class);
            startActivity(Homepage);
            finish();
        }else {
            Toast.makeText(Passworddeclaring.this,"Incorrect Password",Toast.LENGTH_SHORT).show();
        }

    }
    public void changePassword(){
        chpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Change = new Intent(Passworddeclaring.this,DeclarePassword.class);
                startActivity(Change);

            }
        });
    }

}

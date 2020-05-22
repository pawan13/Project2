package com.example.pawansiwakoti.project2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splashscreen extends AppCompatActivity {
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        SharedPreferences settings = getSharedPreferences("PREFS", 0);
        password = settings.getString("password", "");


        Thread myThread = new Thread() {

            public void run() {
                try {
                  sleep(5000);
                  if(password.equals("")) {
                      // if the password is not declared
                      Intent DeclarePassword = new Intent(getApplicationContext(), DeclarePassword.class);
                      startActivity(DeclarePassword);
                      finish();
                  }else {
                      Intent DeclarePassword = new Intent(getApplicationContext(), Passworddeclaring.class);
                      startActivity(DeclarePassword);
                      finish();
                  }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }


}


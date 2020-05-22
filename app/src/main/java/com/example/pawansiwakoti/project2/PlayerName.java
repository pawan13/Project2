package com.example.pawansiwakoti.project2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PlayerName extends AppCompatActivity {
    public static final String PREFS_Name = "";
    public static final String PREFS_KEY = "";



    EditText PlayerXName, PlayerOName;
    Button setname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name);
        PlayerXName = (EditText) findViewById(R.id.PlayerX);
        PlayerOName = (EditText) findViewById(R.id.PlayerO);
        setname = (Button) findViewById(R.id.btnsetName);
        Setname();


    }

    public void Setname() {
        setname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String playerXName = PlayerXName.getText().toString();
                String playerOName = PlayerOName.getText().toString();
                if (playerXName.equals("")
                        || (playerOName.equals(""))) {
                    // if the  Players Name are not entered
                    Toast.makeText(PlayerName.this, "Please enter the players name:", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences settings;
                    SharedPreferences.Editor editor;
                    settings = getSharedPreferences("MySharedPreferenceFile", 0);
                    editor = settings.edit();
                    editor.putString("editTextContent", playerXName);
                    editor.putString("editTextContent1", playerOName);
                    editor.apply();

                    Intent EnterName = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(EnterName);
                    finish();
                }
            }

        });
    }

    }




package com.example.pawansiwakoti.project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     Button New_Game;
     Button HighScores,Help, Enquire;

    public void NewGame(){
        New_Game = (Button)findViewById(R.id.btn_New_Game);
        New_Game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent NewGame = new Intent(MainActivity.this,NewGameActivity.class);
             startActivity(NewGame);
            }
        });
    }
    public void HighScores(){
        HighScores = (Button)findViewById(R.id.btn_high_scores);
        HighScores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Highscores = new  Intent(MainActivity.this, HighScore.class);
                startActivity(Highscores);
            }
        });
    }
    public void Help(){
        Help = (Button)findViewById(R.id.btn_Help);
        Help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent help = new  Intent(MainActivity.this, Help.class);
                startActivity(help);
            }
        });
    }
    public void Enquire(){
        Enquire = (Button)findViewById(R.id.btn_Enquire);
        Enquire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent enquire = new  Intent(MainActivity.this, Enquire.class);
                startActivity(enquire);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NewGame();
        HighScores();
        Help();
        Enquire();
    }
}

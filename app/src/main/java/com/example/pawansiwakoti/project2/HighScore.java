package com.example.pawansiwakoti.project2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HighScore extends AppCompatActivity {
    TextView hscore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        hscore = (TextView)findViewById(R.id.high_scores);

    }
    void gethighscore(){
        SharedPreferences settings = getSharedPreferences("MyHighScore", 0);
        String highscore = settings.getString("highscore","");
        hscore.setText(highscore);
    }

    @Override
    protected void onStart(){
        super.onStart();
       gethighscore();
    }
}


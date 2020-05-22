package com.example.pawansiwakoti.project2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GameHistory extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_history);
       textView = (TextView)findViewById(R.id.gameHistory);
        onStart();

        }
        void gethistory(){
            SharedPreferences settings = getSharedPreferences("MyGameHistory", 0);
            String History = settings.getString("History","");
            textView.setText(History);

        }

    @Override
    protected void onStart(){
        super.onStart();
        gethistory();
    }

    }


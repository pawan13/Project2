package com.example.pawansiwakoti.project2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    TextView name, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        name = (TextView)findViewById(R.id.txtsname);
        message = (TextView)findViewById(R.id.txtsmessage);

       Player oxplayer = (Player) getIntent().getSerializableExtra("sendDATA");

       String Stname = oxplayer.getStnames();
       String Stmessage = oxplayer.getStmessage();


       name.setText(Stname);
       message.setText(Stmessage);
    }
}

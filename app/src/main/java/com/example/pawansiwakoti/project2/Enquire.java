package com.example.pawansiwakoti.project2;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Enquire extends AppCompatActivity {

    Button show;
    EditText names;
    EditText message;
    TextView text;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquire);

        show = (Button) findViewById(R.id.btnshow);
        names = (EditText) findViewById(R.id.txtName);
        message = (EditText) findViewById(R.id.edit_query);



        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stnames = names.getText().toString();
                String stmessage = message.getText().toString();

                Player oxplayer = new Player (stnames, stmessage);

                Intent mainAct = new Intent (Enquire.this, DisplayActivity.class);
                mainAct.putExtra("sendDATA", oxplayer);
                startActivity(mainAct);

            }
        });
    }



}

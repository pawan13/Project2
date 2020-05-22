package com.example.pawansiwakoti.project2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeclarePassword extends AppCompatActivity {

    EditText password2, confirmPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_declare_password);

        password2 = (EditText)findViewById(R.id.password);
        confirmPassword = (EditText)findViewById(R.id.confirmpassword);

    }
    public void onregisterClick(View v){
        String Password = password2.getText().toString();
        String ConfirmPassword = confirmPassword.getText().toString();

        if (Password.equals("")){
            Toast.makeText(DeclarePassword.this,"Please enter the password", Toast.LENGTH_SHORT).show();
        }else if (Password.equals("") || (ConfirmPassword.equals(""))) {
            Toast.makeText(DeclarePassword.this, "Please confirm the npassword", Toast.LENGTH_SHORT).show();
        }else if (Password.equals(ConfirmPassword)){
            SharedPreferences settings = getSharedPreferences("PREFS", 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("password", Password);
            editor.apply();
            //To access the app enter the password
            Intent LogIn = new Intent(getApplicationContext(), Passworddeclaring.class);
            startActivity(LogIn);
            finish();
        }else {
            Toast.makeText(DeclarePassword.this,"Password did not match. Please enter the same password", Toast.LENGTH_SHORT).show();
        }
    }
}

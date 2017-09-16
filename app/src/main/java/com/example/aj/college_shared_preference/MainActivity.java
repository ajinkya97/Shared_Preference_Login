package com.example.aj.college_shared_preference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button login;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText)findViewById(R.id.user);
        password=(EditText)findViewById(R.id.pass);
        login=(Button)findViewById(R.id.login);

        sp=getSharedPreferences("login",MODE_PRIVATE);

        //if SharedPreferences contains username and password then directly redirect to Home activity
        if(sp.contains("username") && sp.contains("password")){
            startActivity(new Intent(MainActivity.this,profile.class));
            finish();   //finish current activity
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginCheck();
            }
        });
    }

    void loginCheck(){
        //check username and password are correct and then add them to SharedPreferences
        if(username.getText().toString().equals("programmer") && password.getText().toString().equals("programmer")){
            SharedPreferences.Editor e=sp.edit();
            e.putString("username","programmer");
            e.putString("password","programmer");
            e.commit();

            Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_LONG).show();

            startActivity(new Intent(MainActivity.this,profile.class));
            finish();
        }
        else{
            Toast.makeText(MainActivity.this,"Incorrect Login Details",Toast.LENGTH_LONG).show();
        }
    }
}

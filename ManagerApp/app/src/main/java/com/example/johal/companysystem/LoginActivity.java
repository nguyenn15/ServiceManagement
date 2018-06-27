package com.example.johal.companysystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    Button login;
    EditText email,password;
    List<String> loginManager=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=(Button)findViewById(R.id.login);
        email=(EditText)findViewById(R.id.userId);
        password=(EditText)findViewById(R.id.password);
        loginManager.add("arsh");
        loginManager.add("12345");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().equals(loginManager.get(0))
                        &&password.getText().toString().equals(loginManager.get(1)))
                {
                    Intent myIntent = new Intent(LoginActivity.this,
                            managerHomePage.class);
                    startActivity(myIntent);
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"fill crediantels",Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}

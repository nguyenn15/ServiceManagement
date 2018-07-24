package com.example.a300273215.admin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ORM.User;
import Service.FactoryServiceAPI;
import Service.UserApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button login;
    EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(Button)findViewById(R.id.login);
        email=(EditText)findViewById(R.id.userId);
        password=(EditText)findViewById(R.id.password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login(); // handle login
            }
        });


    }

    public void Login()
    {
        final String uname = email.getText().toString();
        final String pass = password.getText().toString();
        final String usertype = "ADMIN"; // this app is for ADMIN


        if (uname.isEmpty() || pass.isEmpty()) {
            Toast.makeText(LoginActivity.this, "Fill Credentials", Toast.LENGTH_SHORT).show();
            return;
        }


        Map<String, String> params = new HashMap<String, String>();
        params.put("username", uname);
        params.put("password", pass);
        params.put("usertype", usertype); /// ADMIN, CUSTOMER, EMPLOYEE, MANAGER

        try {
            UserApi userapi = FactoryServiceAPI.GetUserApi();
            Call<User> users = userapi.Login(params);
            users.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    // login succes if id >0
                    User user = response.body();
                    if(user.getId()>0)
                    {
                        FactoryServiceAPI.currentUser = user; // keep current logged user to system
                        SharedPreferences.Editor editor = getSharedPreferences("login",MODE_PRIVATE).edit();
                        editor.putString("login", "Login");
                        editor.apply();
                        Intent myIntent = new Intent(LoginActivity.this,
                                AdminHomePage.class);
                        startActivity(myIntent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this,"Invalid Username or Password!",Toast.LENGTH_SHORT).show();
                        email.setText("");
                        password.setText("");
                        email.requestFocus();
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                        int i=0;
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

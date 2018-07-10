package com.example.a300273215.admin;

import android.content.Intent;
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
        final String usertype = "ADMIN"; // this app is for customer

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

                        Intent myIntent = new Intent(LoginActivity.this,
                                AdminHomePage.class);
                        startActivity(myIntent);
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this,"fill crediantels",Toast.LENGTH_SHORT).show();
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

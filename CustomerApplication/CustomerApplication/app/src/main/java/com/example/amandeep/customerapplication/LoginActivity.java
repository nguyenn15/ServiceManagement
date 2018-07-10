package com.example.amandeep.customerapplication;

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
import Service.UserApi;
import Service.FactoryServiceAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button login;
    EditText email;
    EditText password;

    User user; // store current logged user

    @Override
    protected void onCreate(Bundle savedInstanceState)   {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login=(Button)findViewById(R.id.login);
        email=(EditText)findViewById(R.id.userId);
        password=(EditText)findViewById(R.id.password);

        // handler for click login button
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
        final String usertype = "CUSTOMER"; // this app is for customer

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
                    user = response.body();
                    if(user.getId()>0)
                    {
                        FactoryServiceAPI.currentUser = user; // keep current logged user to system

                        Intent myIntent = new Intent(LoginActivity.this,
                                CustomerPage.class);
                         startActivity(myIntent);
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this,"fill crediantels",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/*
    public void users()
    {
        try {
            UserApi userapi = factoryServiceAPI.GetUserApi();
            Call<List<User>> users = userapi.Users();
            users.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                    int i=0;
                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/

}

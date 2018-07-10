package com.example.amandeep.customerapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ORM.User;
import ORM.UserType;
import Service.UserApi;
import Service.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    Button login;
    EditText email;
    EditText password;
    List<String> loginCustomer=new ArrayList<>();

    // service for login
    UserService myUserService;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState)   {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login=(Button)findViewById(R.id.login);
        email=(EditText)findViewById(R.id.userId);
        password=(EditText)findViewById(R.id.password);

        //loginCustomer.add("arsh");
        //loginCustomer.add("12345");

        myUserService = new UserService();
        //

        users();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String uname = email.getText().toString();
                final String pass = password.getText().toString();
                final String usertype = "CUSTOMER"; // this app is for customer

                User user =new User(); //myUserService.login(uname,pass,usertype);
                // create async task


                if(user!=null)
                {
                    Intent myIntent = new Intent(LoginActivity.this,
                            CustomerPage.class);
                   // startActivity(myIntent);
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"fill crediantels",Toast.LENGTH_SHORT).show();
                }


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
            UserApi userapi = myUserService.GetUserApi();
            Call<User> users = userapi.Login(params);
            users.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    // login succes if id >0
                    user = response.body();
                    if()
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void users()
    {
        try {
            UserApi userapi = myUserService.GetUserApi();
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


}

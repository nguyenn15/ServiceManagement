package com.example.johal.companysystem;

/**
 * Created by 300273215 on 6/22/2018.
 */

public class Manager {
    String firstname,lastName,email,password;
    int sin,id;

    public Manager(int id,String fn,String ln,int sin,String email,String password)
    {
        this.firstname=fn;
        this.lastName=ln;
        this.email=email;
        this.password=password;

        this.sin=sin;
        this.id=id;
    }
}

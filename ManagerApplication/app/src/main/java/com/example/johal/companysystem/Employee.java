package com.example.johal.companysystem;

/**
 * Created by 300273215 on 6/22/2018.
 */

public class Employee {
    String firstname,lastName,email,password,position;
    int sin,id;

    public Employee(int id,String fn,String ln,int sin,String email,String password,String position)
    {
        this.id=id;
        this.firstname=fn;
       this.lastName=ln;
        this.sin=sin;
       this.email=email;
       this.password=password;
       this.position=position;


    }


}

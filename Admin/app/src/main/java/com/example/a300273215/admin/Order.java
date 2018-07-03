package com.example.a300273215.admin;

public class Order {
    private int id;
    private String status;
    private String name;

    public Order(int id, String name, String status)
    {
       this.id=id;
       this.name=name;
       this.status=status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

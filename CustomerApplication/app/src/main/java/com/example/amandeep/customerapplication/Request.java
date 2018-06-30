package com.example.amandeep.customerapplication;

/**
 * Created by Amandeep on 2018-06-29.
 */

public class Request {
    double area;
    int no_Of_Doors,entry_Exit_Doors,open_Windows,open_Area,door_bells,requestid;
    String address,requeststatus;

    public Request(double area, int no_Of_Doors, int entry_Exit_Doors, int open_Windows, int open_Area, int door_bells, int requestid, String address, String requeststatus) {
        this.area = area;
        this.no_Of_Doors = no_Of_Doors;
        this.entry_Exit_Doors = entry_Exit_Doors;
        this.open_Windows = open_Windows;
        this.open_Area = open_Area;
        this.door_bells = door_bells;
        this.requestid = requestid;
        this.address = address;
        this.requeststatus = requeststatus;
    }

    public int getRequestid() {
        return requestid;
    }

    public void setRequestid(int requestid) {
        this.requestid = requestid;
    }

    public String getRequeststatus() {
        return requeststatus;
    }

    public void setRequeststatus(String requeststatus) {
        this.requeststatus = requeststatus;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getNo_Of_Doors() {
        return no_Of_Doors;
    }

    public void setNo_Of_Doors(int no_Of_Doors) {
        this.no_Of_Doors = no_Of_Doors;
    }

    public int getEntry_Exit_Doors() {
        return entry_Exit_Doors;
    }

    public void setEntry_Exit_Doors(int entry_Exit_Doors) {
        this.entry_Exit_Doors = entry_Exit_Doors;
    }

    public int getOpen_Windows() {
        return open_Windows;
    }

    public void setOpen_Windows(int open_Windows) {
        this.open_Windows = open_Windows;
    }

    public int getOpen_Area() {
        return open_Area;
    }

    public void setOpen_Area(int open_Area) {
        this.open_Area = open_Area;
    }

    public int getDoor_bells() {
        return door_bells;
    }

    public void setDoor_bells(int door_bells) {
        this.door_bells = door_bells;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

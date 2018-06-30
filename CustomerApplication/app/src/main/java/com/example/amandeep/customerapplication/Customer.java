package com.example.amandeep.customerapplication;

/**
 * Created by Amandeep on 2018-06-29.
 */

public class Customer {
    int customerId;
    String customerFrstName;
    String customerLastName;
    String userId;
    String password;


    public Customer(int customerId, String customerFrstName, String customerLastName, String userId, String password) {
        this.customerId = customerId;
        this.customerFrstName = customerFrstName;
        this.customerLastName = customerLastName;
        this.userId = userId;
        this.password = password;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerFrstName() {
        return customerFrstName;
    }

    public void setCustomerFrstName(String customerFrstName) {
        this.customerFrstName = customerFrstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

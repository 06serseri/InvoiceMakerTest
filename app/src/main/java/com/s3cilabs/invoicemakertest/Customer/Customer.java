package com.s3cilabs.invoicemakertest.Customer;

public class Customer {
    private int customerId;
    private String customerName;
    private String customerBillToAddress;
    private String customerShipToAddress;
    private String customerEmail;
    private int customerPhone;

    //Constructor
    public Customer(int customerId, String customerName, String customerBillToAddress,
                    String customerShipToAddress, String customerEmail, int customerPhone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerBillToAddress = customerBillToAddress;
        this.customerShipToAddress = customerShipToAddress;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
    }

    //Empty constructor
    public Customer() {
    }

    //toString

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerBillToAddress='" + customerBillToAddress + '\'' +
                ", customerShipToAddress='" + customerShipToAddress + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerPhone=" + customerPhone +
                '}';
    }

    //Getters and Setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBillToAddress() {
        return customerBillToAddress;
    }

    public void setCustomerBillToAddress(String customerBillToAddress) {
        this.customerBillToAddress = customerBillToAddress;
    }

    public String getCustomerShipToAddress() {
        return customerShipToAddress;
    }

    public void setCustomerShipToAddress(String customerShipToAddress) {
        this.customerShipToAddress = customerShipToAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(int customerPhone) {
        this.customerPhone = customerPhone;
    }
}

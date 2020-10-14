package com.quocnguyen.model;

public class Customer {
    private long idCustomer;
    private String nameCustomer;
    private String dayOfBirth;

    public Customer(long idCustomer, String nameCustomer, String dayOfBirth) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.dayOfBirth = dayOfBirth;
    }

    public long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public Customer() {
    }
}

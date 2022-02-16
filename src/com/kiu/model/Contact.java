package com.kiu.model;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String gender;
    private String phoneNumber;
    private String address;
    private String email;
    private String phoneGroup;

    public Contact() {
    }

    public Contact(String name, String gender, String phoneNumber, String address, String email, String phoneGroup) {
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.phoneGroup = phoneGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneGroup() {
        return phoneGroup;
    }

    public void setPhoneGroup(String phoneGroup) {
        this.phoneGroup = phoneGroup;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + this.name + '\'' +
                ", gender='" + this.gender + '\'' +
                ", phoneNumber='" + this.phoneNumber + '\'' +
                ", address='" + this.address + '\'' +
                ", email='" + this.email + '\'' +
                ", phoneGroup='" + this.phoneGroup + '\'' + '}';
    }
}

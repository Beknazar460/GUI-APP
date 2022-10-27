package com.example.authguiapp.entities;

public class UserEntity {

    private String email;
    private String firstName;
    private String lastName;
    private String pass;
    private String phoneNumber;
    private String confirmPass;

    public UserEntity(String email, String firstName, String lastName, String pass, String phoneNumber, String confirmPass) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pass = pass;
        this.phoneNumber = phoneNumber;
        this.confirmPass = confirmPass;
    }

    public UserEntity() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getConfirmPass() {
        return confirmPass;
    }
}


package com.dh10.access.model.beans;

public class User implements Bean {
    String userId;
    String firstName;
    String lastName;
    String Country;
    String Password;

    public User() {

    }

    public User(String userId, String firstName, String lastName, String country, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        Country = country;
        Password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

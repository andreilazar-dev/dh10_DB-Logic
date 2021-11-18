package com.dh10.stringchecker.model.beans;

public class Country implements Bean {

    private String country_name;

    public Country() {
    }

    public Country(String country_name) {
        this.country_name = country_name;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

}


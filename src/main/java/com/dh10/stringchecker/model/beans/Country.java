package com.dh10.stringchecker.model.beans;


import java.util.Set;

public class Country implements Bean {

    private String country_name;
    private Set synonymus;

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

    public Set getSynonymus() {
        return synonymus;
    }

    public void setSynonymus(Set synonymus) {
        this.synonymus = synonymus;
    }
}

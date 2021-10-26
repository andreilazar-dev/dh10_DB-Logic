package com.dh10.stringchecker.model.beans;

public class Synonymus implements Bean {

    String synonymus_name;
    String algorithm_name;
    int status;
    Country country;

    public Synonymus() {
    }

    public Synonymus(String synonymus_name, String algorithm_name, int status, Country country) {
        this.synonymus_name = synonymus_name;
        this.algorithm_name = algorithm_name;
        this.status = status;
        this.country = country;
    }

    public String getSynonymus_name() {
        return synonymus_name;
    }

    public void setSynonymus_name(String synonymus_name) {
        this.synonymus_name = synonymus_name;
    }

    public String getAlgorithm_name() {
        return algorithm_name;
    }

    public void setAlgorithm_name(String algorithm_name) {
        this.algorithm_name = algorithm_name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!this.getClass().equals(obj.getClass())) return false;
        Synonymus obj2 = (Synonymus) obj;
        if((this.synonymus_name.equals(obj2.getSynonymus_name()))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int tmp = 0;
        tmp = ( synonymus_name).hashCode();
        return tmp;
    }
}

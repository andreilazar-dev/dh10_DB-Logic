package com.dh10.stringchecker.model;

public class Synonymus {

    String synonymus_name;
    String algorithm_name;
    String status;

    public Synonymus() {
    }

    public Synonymus(String synonymus_name, String algorithm_name, String status) {
        this.synonymus_name = synonymus_name;
        this.algorithm_name = algorithm_name;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

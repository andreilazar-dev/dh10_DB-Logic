package com.dh10;

import com.dh10.stringchecker.CountryChecker;
import com.dh10.stringchecker.StringChecker;

public class DemoStringChecker {

    public static void main(String[] args) {

        StringChecker countrycheck = new CountryChecker();
        if(countrycheck.find_standard("Afghani")!=null)
            System.out.println(countrycheck.find_standard("Afghani"));
        else {
        	 System.out.println("nazione non trovata");
        }
        
    }
}

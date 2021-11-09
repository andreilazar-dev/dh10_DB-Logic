package com.dh10;

import com.dh10.stringchecker.CountryChecker;
import com.dh10.stringchecker.StringChecker;

public class DemoStringChecker {

    public static void main(String[] args) {

        StringChecker countrycheck = new CountryChecker();
        String out = "";
       out = countrycheck.find_standard("Afghanis");
       System.out.println(out);


        
    }
}

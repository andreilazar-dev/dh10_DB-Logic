package com.dh10;

import com.dh10.stringchecker.CountryChecker;
import com.dh10.stringchecker.StringChecker;
import com.dh10.stringchecker.controller.recover.db.Countries;
import com.dh10.stringchecker.controller.recover.json.Filler;
import com.dh10.stringchecker.controller.string.Contained;
import com.dh10.stringchecker.controller.string.Contains;
import com.dh10.stringchecker.controller.string.Levensthein;
import com.dh10.stringchecker.controller.string.StringCheckerDef;
import com.dh10.stringchecker.utils.DBaccess;

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

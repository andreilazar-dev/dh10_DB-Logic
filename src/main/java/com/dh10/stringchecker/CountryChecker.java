package com.dh10.stringchecker;

import com.dh10.stringchecker.controller.recover.db.Countries;
import com.dh10.stringchecker.controller.recover.json.Filler;
import com.dh10.stringchecker.controller.string.Contained;
import com.dh10.stringchecker.controller.string.Contains;
import com.dh10.stringchecker.controller.string.Levensthein;
import com.dh10.stringchecker.controller.string.StringCheckerDef;
import com.dh10.stringchecker.utils.DBaccess;

public class CountryChecker extends StringChecker {
    private StringCheckerDef cs = null;
    public CountryChecker(){
        if (!(DBaccess.getIsEmpty("Country"))) {
            System.out.println("Table countries is Empty i fill it ....... ");
            Filler filler = new Filler();
            filler.addCountries();
        }

        cs= new Contains();
        StringCheckerDef cs2= new Contained();
        Levensthein cs3= new Levensthein();  cs3.setDistanzaMax(1);
        Levensthein cs4= new Levensthein();  cs4.setDistanzaMax(2);
        Levensthein cs5= new Levensthein();  cs5.setDistanzaMax(3);
        cs.setNext(cs2);
        cs2.setNext(cs3);
        cs3.setNext(cs4);
        cs4.setNext(cs5);
        cs.setParoleStandard(new Countries());
        cs2.setParoleStandard(new Countries());
        cs3.setParoleStandard(new Countries());
        cs4.setParoleStandard(new Countries());
    }
    public boolean find_standard (String word){
         return cs.check(word);
    }
}

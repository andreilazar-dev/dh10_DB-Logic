package com.dh10.stringchecker;

import com.dh10.stringchecker.controller.recover.db.Countries;
import com.dh10.stringchecker.controller.string.Contained;
import com.dh10.stringchecker.controller.string.Contains;
import com.dh10.stringchecker.controller.string.Levensthein;
import com.dh10.stringchecker.controller.string.StringCheckerDef;

public class StringChecker {
    private StringCheckerDef cs = null;
    public StringChecker (){
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
    public String find_standard (String word){
        cs.check(word);
    }
}

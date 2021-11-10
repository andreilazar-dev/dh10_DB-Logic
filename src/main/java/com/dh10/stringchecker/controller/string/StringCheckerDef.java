package com.dh10.stringchecker.controller.string;

import com.dh10.stringchecker.controller.recover.db.StandardWords;
import com.dh10.stringchecker.model.beans.Country;
import com.dh10.stringchecker.model.beans.Synonymus;
import com.dh10.stringchecker.model.dao.Dao;
import com.dh10.stringchecker.model.dao.SynonymusDao;

public abstract class StringCheckerDef implements StringChecker {
    StandardWords paroleStandard;
    StringChecker next = null;
    private Dao<Synonymus> synonymusDao = new SynonymusDao();

    public void setParoleStandard(StandardWords paroleStandard) {
        this.paroleStandard = paroleStandard;
    }


    public void setNext(StringChecker next) {
        this.next = next;
    }


    abstract boolean check(String input, String standard);
    
   

    @Override
    public String check(String input) {
        for (String standard : paroleStandard.getStandars()) {
            if (check(input, standard)) {
                System.out.println("Trovata corrispondenza = " + standard + "  " + this.getClass().getSimpleName());
                synonymusDao.save(new Synonymus(input,this.getClass().getSimpleName().toString(),1 ,new Country(standard)));
                return standard;
            }
        }
        
        if (next != null) {
            System.out.println(this.getClass().getSimpleName() + " non ha trovato corrispondenza, procedo con il successivo");
            return next.check(input);

        }else {
            System.out.println("Nessuna corrispondenza trovata ");
            synonymusDao.save(new Synonymus(input, null ,1 ,null));
        }
   
        return null;
    }
}

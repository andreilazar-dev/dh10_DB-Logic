package com.dh10.stringchecker.controller.string;

import com.dh10.stringchecker.controller.recover.db.StandardWords;
import com.dh10.stringchecker.controller.recover.db.StandardWords;

public abstract class StringCheckerDef implements StringChecker {
    StandardWords paroleStandard;
    StringChecker next = null;

    public void setParoleStandard(StandardWords paroleStandard) {
        this.paroleStandard = paroleStandard;
    }


    public void setNext(StringChecker next) {
        this.next = next;
    }


    abstract boolean check(String input, String standard);

    @Override
    public final boolean check(String input) {

        for (String standard : paroleStandard.getStandars()) {
            if (check(input, standard)) {
                System.out.println("Trovata corrispondenza = " + standard + "  " + this.getClass().getSimpleName());
                return true;
            }
        }
        if (next != null) {
            System.out.println(this.getClass().getSimpleName() + " non ha trovato corrispondenza, procedo con il successivo");
            return next.check(input);

        } else {
            System.out.println("Nessuna corrispondenza trovata ");
        }
        return false;
    }
}

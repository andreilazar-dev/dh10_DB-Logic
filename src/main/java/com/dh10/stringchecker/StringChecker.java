package com.dh10.stringchecker;

import com.dh10.stringchecker.controller.string.StringCheckerDef;
import com.dh10.stringchecker.utils.DBaccess;

public abstract class StringChecker {
    DBaccess dbAccess = null ;
    public  StringChecker (){
        dbAccess = DBaccess.getInstance();
    }

    public abstract boolean find_standard(String word);
}

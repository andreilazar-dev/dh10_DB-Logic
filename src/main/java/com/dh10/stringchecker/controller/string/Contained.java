package com.dh10.stringchecker.controller.string;

public class Contained extends StringCheckerDef implements StringChecker {
    @Override
    public boolean check(String input, String standard) {
        return standard.contains(input);
    }

}

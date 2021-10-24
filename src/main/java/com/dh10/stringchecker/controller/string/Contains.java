package com.dh10.stringchecker.controller.string;

public class Contains extends StringCheckerDef implements StringChecker {

    @Override
    public boolean check(String input, String standard) {
        return input.contains(standard);
    }
}

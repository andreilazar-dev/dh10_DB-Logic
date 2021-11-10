package com.dh10.stringchecker.controller.string;

import java.util.HashSet;
import java.util.Set;

public class Jaccard extends StringCheckerDef implements StringChecker {
    private double maxvalue=0.80;

    @Override
    public boolean check(String parola, String parola2) {
    	 if (parola == null || parola2 == null) {
             throw new IllegalArgumentException("Input cannot be null");
         }
        double ris;

        ris = Math.round(calculateJaccard(parola, parola2) * 100d) / 100d;
        System.out.println(parola + " -- " +parola2 +" Jaccard: " + ris);
        if(ris > maxvalue) maxvalue=ris;
        if (ris == maxvalue)
            return true;
        else
            return false;
    }

   
    public static double calculateJaccard(String parola, String parola2) {
    	 Set<String> intersectionSet = new HashSet<String>();
         Set<String> unionSet = new HashSet<String>();
         boolean unionFilled = false;
         int parolaLength = parola.length();
         int parola2Length = parola2.length();
         if (parolaLength == 0 || parola2Length == 0) {
             return 0;
         }

         for (int leftIndex = 0; leftIndex < parolaLength; leftIndex++) {
             unionSet.add(String.valueOf(parola.charAt(leftIndex)));
             for (int rightIndex = 0; rightIndex < parola2Length; rightIndex++) {
                 if (!unionFilled) {
                     unionSet.add(String.valueOf(parola2.charAt(rightIndex)));
                 }
                 if (parola.charAt(leftIndex) == parola2.charAt(rightIndex)) {
                     intersectionSet.add(String.valueOf(parola.charAt(leftIndex)));
                 }
             }
             unionFilled = true;
         }
         return Double.valueOf(intersectionSet.size()) / Double.valueOf(unionSet.size());

    }

}

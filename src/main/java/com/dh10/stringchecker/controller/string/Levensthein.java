package com.dh10.stringchecker.controller.string;

import java.util.Arrays;

public class Levensthein extends StringCheckerDef implements StringChecker {
    private int distanzaMax = 0;

    @Override
    public boolean check(String parola, String parola2) {

        int ris;

        ris = Levensthein.leventhein(parola, parola2);
        if (ris == distanzaMax)
            return true;
        else
            return false;
    }

    public void setDistanzaMax(int distanzaMax) {
        this.distanzaMax = distanzaMax;
    }

    public static int leventhein(String parola, String parola2) {
        int[][] dp = new int[parola.length() + 1][parola2.length() + 1];
        for (int i = 0; i <= parola.length(); i++) {
            for (int j = 0; j <= parola2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = min(dp[i - 1][j - 1]
                                    + costOfSubstitution(parola.charAt(i - 1), parola2.charAt(j - 1)),
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1);
                }
            }
        }
        return dp[parola.length()][parola2.length()];
    }
    public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }
    public static int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
    }

}

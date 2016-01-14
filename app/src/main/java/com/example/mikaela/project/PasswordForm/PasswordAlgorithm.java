package com.example.mikaela.project.PasswordForm;

import android.content.Context;

/**
 * Created by mikaela on 16-01-09.
 */
public class PasswordAlgorithm {
    Context context;
    int good = 1, bad = 0;

    public PasswordAlgorithm() {


    }

    public int PasswordStrength(String s){
        //kunna ändra antal steg: egen funktion
        int nrOfCharacters = 6;
        int nrOfNumbers = 2;
        int nrOfCapitalLetters = 1;
        int sum = 0;

        boolean isNumberOfCorrect = checkNrOfCharacters(s, nrOfCharacters);
        sum += checkNrOfNumbers(s, nrOfNumbers);
        sum += checkNrOfCapitalLetters(s, nrOfCapitalLetters);

        if(isNumberOfCorrect){
            sum++;
            return sum;
        }

        return 0;
    }

    public boolean checkNrOfCharacters(String s, int n){
        if(s.length() >= n) {
            return true;
        }
        else return false;
    }

    public int checkNrOfNumbers(String s, int n){
        int count = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                count++;
            }
        }
        if(count >= n) return good;
        else return bad;
    }

    public int checkNrOfCapitalLetters(String s, int n){
        int count = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                count++;
            }
        }
        if(count >= n) return good;
        else return bad;
    }
}

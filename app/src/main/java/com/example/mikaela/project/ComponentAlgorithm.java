package com.example.mikaela.project;

import android.content.Context;

/**
 * Created by mikaela on 16-01-09.
 */
public class ComponentAlgorithm{
    Context context;
    int good = 3, medium = 2, bad = 1;
    Boolean[] checkedConditions;

    public ComponentAlgorithm() {
        checkedConditions = new Boolean[6];
        //PasswordStrength(s);

    }

    public int PasswordStrength(String s){
        //välj hur ett bra lösenord ska vara
        //kunna ändra antal steg: egen funktion
        int nrOfCharacters = 6;
        int nrOfNumbers = 2;
        int nrOfCapitalLetters = 1;
        int sum = 0;

        sum += checkNrOfCharacters(s, nrOfCharacters);
        sum += checkNrOfNumbers(s, nrOfNumbers);
        sum += checkNrOfCapitalLetters(s, nrOfCapitalLetters);

        return sum;
    }

    public int checkNrOfCharacters(String s, int n){
        if(s.length() > n) return good;
        else if(s.length() < n/3) return bad;
        else return medium;
    }

    public int checkNrOfNumbers(String s, int n){
        int count = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                count++;
            }
        }
        if(count >= good) return good;
        else if(count <= bad) return bad;
        else return medium;
    }

    public int checkNrOfCapitalLetters(String s, int n){
        int count = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                count++;
            }
        }
        if(count >= good) return good;
        else if(count <= bad) return bad;
        else return medium;
    }
}

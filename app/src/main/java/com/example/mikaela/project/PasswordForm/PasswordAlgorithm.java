package com.example.mikaela.project.PasswordForm;


/**
 *  This class is the algorithm determining how good a password is.
 *  It is possible to change the number of characters, numbers and capital letters.
 *  Also possible to change the points you get for every correct answer and the number of
 *  steps available to visualize.
 */
public class PasswordAlgorithm {

    int good = 1, bad = 0, numberOfSteps = 2;


    public int getNumberOfSteps(){
        return numberOfSteps;
    }

    /** The following function decides how many characters, number etc needed
     * for a good password. It checks the current word and add points to a sum-variable
     * which is used in the visualisation to decide what color to set.*/
    public int PasswordStrength(String s){

        int nrOfCharacters = 6;
        int nrOfNumbers = 2;
        int nrOfCapitalLetters = 1;
        int sum = 0;

        boolean isNumberOfCorrect = checkNrOfCharacters(s, nrOfCharacters);
        sum += checkNrOfNumbers(s, nrOfNumbers);
        sum += checkNrOfCapitalLetters(s, nrOfCapitalLetters);

        if(isNumberOfCorrect){
            return sum;
        }

        return 0;
    }

    private boolean checkNrOfCharacters(String s, int n){
        if(s.length() >= n) {
            return true;
        }
        else return false;
    }

    private int checkNrOfNumbers(String s, int n){
        int count = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                count++;
            }
        }
        if(count >= n) return good;
        else return bad;
    }

    private int checkNrOfCapitalLetters(String s, int n){
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

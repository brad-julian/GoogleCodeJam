/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.google.codejam.twentyeight.practice.problems;

import com.google.codejam.CodeJamProblem;
import java.util.Scanner;

/**
 *
 * @author bjulian
 */
public class AlienNumbers extends CodeJamProblem {
    
    AlienNumbers(String filename) {
        super(filename);
    }
    
    @Override
    protected String solveIteration() {
        String[] lineOfWords = fileScanner.nextLine().split(" ");
        
        int numberInDecimal = decodeToDecimal(lineOfWords[0], lineOfWords[1]);
        return encodeFromDecimal(numberInDecimal, lineOfWords[2]);
    }
    
    private static int decodeToDecimal(String alienNumber, String sourceLanguage) {
        int base   = sourceLanguage.length();
        int length = alienNumber.length();
        
        int numberInDecimal = 0;
        numberInDecimal += sourceLanguage.indexOf(alienNumber.charAt(0));
        for (int i=1; i<length; i++) {
            numberInDecimal = numberInDecimal * base;
            numberInDecimal += sourceLanguage.indexOf(alienNumber.charAt(i));
        }
        return numberInDecimal;
    }
    
    private static String encodeFromDecimal(int number, String targetLanguage) {
        int base = targetLanguage.length();
        String numberInTarget = "";
        while (number > 0) {
            numberInTarget = targetLanguage.charAt(number%base) + numberInTarget;
            number = number/base;
        }
        return numberInTarget;
    }
    
    public static void main(String[] args) {
        String filename;
        if (args.length > 0) {
            filename = args[0];
        }
        else {
            Scanner userIn = new Scanner(System.in);
            System.out.print("Please provide the name (sans extension) of the input file for this problem: ");
            filename = userIn.nextLine();
            userIn.close();
            System.out.println("Now running the problem...");   
        }
        new AlienNumbers(filename).run();
    }
}

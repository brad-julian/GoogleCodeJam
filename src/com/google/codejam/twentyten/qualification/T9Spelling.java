/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.google.codejam.twentyten.qualification;

import com.google.codejam.CodeJamProblem;
import java.util.Scanner;

/**
 *
 * @author BJulian
 */
public class T9Spelling extends CodeJamProblem {
    
    private static final String ABC  = "2";
    private static final String DEF  = "3";
    private static final String GHI  = "4";
    private static final String JKL  = "5";
    private static final String MNO  = "6";
    private static final String PQRS = "7";
    private static final String TUV  = "8";
    private static final String WXYZ = "9";
    
    T9Spelling(String filename) {
        super(filename);
    }
    
    @Override
    protected String solveIteration() {
        char[] lineChars = fileScanner.nextLine().toCharArray();
        
        int length = lineChars.length;
        String solution = "";
        int i = 0;
        String prevKeyPress = "";
        for (i=0; i<length; i++) {
            String keyPress = keyForChar(lineChars[i]);
            if (prevKeyPress.equals(keyPress)) {
                solution += " ";
            }
            solution += keyPressMultiplied(lineChars[i], keyPress);
            prevKeyPress = keyPress;
        }
        return solution;
    }
    
    private static String keyForChar(char currChar) {
        String keyPress = "";
        switch (currChar) {
            case ' ':
                return "0";
            case 'a':
            case 'b':
            case 'c':
                return ABC;
            case 'd':
            case 'e':
            case 'f':
                return DEF;
            case 'g':
            case 'h':
            case 'i':
                return GHI;
            case 'j':
            case 'k':
            case 'l':
                return JKL;
            case 'm':
            case 'n':
            case 'o':
                return MNO;
            case 'p':
            case 'q':
            case 'r':
            case 's':
                return PQRS;
            case 't':
            case 'u':
            case 'v':
                return TUV;
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                return WXYZ;
            default:
                return "1";
        }
    }
    
    private static String keyPressMultiplied(char character, String keyPress) {
        int loop = 0;
        switch (character) {
            case 'b':
            case 'e':
            case 'h':
            case 'k':
            case 'n':
            case 'q':
            case 'u':
            case 'x':
                loop = 2;
                break;
            case 'c':
            case 'f':
            case 'i':
            case 'l':
            case 'o':
            case 'r':
            case 'v':
            case 'y':
                loop = 3;
                break;
            case 's':
            case 'z':
                loop = 4;
                break;
            case ' ':
            case 'a':
            case 'd':
            case 'g':
            case 'j':
            case 'm':
            case 'p':
            case 't':    
            case 'w':
            default:
                return keyPress;
        }
        String result = keyPress;
        for (int i=1; i<loop; i++) {
            result += keyPress;
        }
        return result;
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
            new T9Spelling(filename).run();
        }
    }
    
}

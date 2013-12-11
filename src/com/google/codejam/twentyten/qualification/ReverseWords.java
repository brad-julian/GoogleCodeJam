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
public class ReverseWords extends CodeJamProblem {
    
    ReverseWords(String filename) {
        super(filename);
    }
    
    @Override
    protected String solveIteration() {
        String[] lineOfWords = fileScanner.nextLine().split(" ");
        
        String solution = "";
        int i;
        for (i=lineOfWords.length-1; i>0; i--) {
            solution += lineOfWords[i] + " ";
        }
        solution += lineOfWords[i];
        return solution;
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
            new ReverseWords(filename).run();
        }
    }
    
}

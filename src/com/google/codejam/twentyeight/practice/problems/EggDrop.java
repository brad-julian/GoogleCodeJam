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
public class EggDrop extends CodeJamProblem {
    
    EggDrop(String filename) {
        super(filename);
    }
    
    @Override
    protected String solveIteration() {
        throw new UnsupportedOperationException();
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
        new EggDrop(filename).run();
    }
}

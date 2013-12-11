/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.google.codejam.twentyeleven.qualification;

import com.google.codejam.CodeJamProblem;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author BJulian
 */
public class CandySplitting extends CodeJamProblem {
       
    CandySplitting(String filename) {
        super(filename);
    }
    
    @Override
    protected String solveIteration() {
        int numCandies = parseOneIntLine();
        
        String candyLine    = fileScanner.nextLine();
        Scanner lineScanner = new Scanner(candyLine);
        int[] candies = new int[numCandies];
        int patrickSum = 0;
        for (int i=0; i < numCandies; i++) {
            candies[i] = lineScanner.nextInt();
            patrickSum ^= candies[i];
        }
        if (patrickSum == 0) {
            int seanSum = 0;
            Arrays.sort(candies);
            for (int i=1; i < numCandies; i++) {
                seanSum += candies[i];
            }
            return seanSum + "";
        }
        
        return "NO";
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
            new CandySplitting(filename).run();
        }
    }
}

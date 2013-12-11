/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.google.codejam.twentyeleven.r1a;

import com.google.codejam.CodeJamProblem;
import java.util.Scanner;

/**
 *
 * @author BJulian
 */
public class FreeCell extends CodeJamProblem {
    
    FreeCell(String filename) {
        super(filename);
    }
    
    
    @Override
    protected String solveIteration() {        
        String input = fileScanner.nextLine();
        Scanner lineScan = new Scanner(input);
        
        long maxGamesToday = lineScan.nextLong();
        int winPrcntToday = lineScan.nextInt();
        int winPrcntTotal = lineScan.nextInt();
        
        if (winPrcntTotal == 0) {
            return (winPrcntToday > 0) ? "Broken" : "Possible";
        }
        if (winPrcntTotal == 100) {
            return (winPrcntToday < 100) ? "Broken" : "Possible";
        }
        for (int i=1; i <= maxGamesToday; i++) {
            int gamesWonToday = (int)(i*winPrcntToday);
            if (gamesWonToday%100 == 0.0) {
                return "Possible";
            }
        }
        return "Broken";
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
            new FreeCell(filename).run();
        }
    }
}

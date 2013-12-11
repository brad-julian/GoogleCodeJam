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
public class StoreCredit extends CodeJamProblem {
    
    StoreCredit(String filename) {
        super(filename);
    }
    
    @Override
    protected String solveIteration() {
        int credit    = this.parseOneIntLine();
        int numItems  = this.parseOneIntLine();
        String[] itemCosts = fileScanner.nextLine().split(" ");
        
        int firstIndex = 0;
        int secondIndex = -1;
        while (secondIndex<0 && firstIndex<numItems) {
            int itemCost = Integer.parseInt(itemCosts[firstIndex]);
            for (int i=firstIndex+1; i<numItems; i++) {
                if (Integer.parseInt(itemCosts[i]) == (credit-itemCost)) {
                    secondIndex = i + 1;
                    return String.format("%d %d",firstIndex+1,secondIndex);
                }
            }
            firstIndex++;
        }
        System.err.println("A solution could not be found!");
        System.exit(1);
        return "";
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
            new StoreCredit(filename).run();
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.google.codejam.twentyeleven.qualification;

import com.google.codejam.CodeJamProblem;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author BJulian
 */
public class BotTrust extends CodeJamProblem {
    
    BotTrust(String filename) {
        super(filename);
    }
    
    @Override
    protected String solveIteration() {
        List<Integer> orangeButtons = new LinkedList<Integer>();
        List<Integer> blueButtons   = new LinkedList<Integer>();
        List<String>  buttonOrder   = new LinkedList<String>();
       
        String[] buttonSequence = fileScanner.nextLine().split(" ");
        for (int i=1, length=buttonSequence.length; i < length; i++) {
            buttonOrder.add(buttonSequence[i]);
            if (buttonSequence[i].equals("O")) {
                orangeButtons.add(Integer.parseInt(buttonSequence[++i]));
            }
            else {
                blueButtons.add(Integer.parseInt(buttonSequence[++i]));
            }
        }
        
        Integer orangeBot = 1;
        Integer blueBot   = 1;
        
        int totalTime = 0;
        while (!buttonOrder.isEmpty()) {
            int orangeDiff = orangeButtons.isEmpty() ? 0 : comparePosition(orangeButtons.get(0), orangeBot);
            int blueDiff   = blueButtons.isEmpty()   ? 0 : comparePosition(blueButtons.get(0), blueBot);
            
            if ((orangeDiff == 0) && buttonOrder.get(0).equals("O")) {
                buttonOrder.remove(0);
                orangeButtons.remove(0);
            }
            else if ((blueDiff == 0) && buttonOrder.get(0).equals("B")) {
                buttonOrder.remove(0);
                blueButtons.remove(0);
            }
            orangeBot += orangeDiff;
            blueBot   += blueDiff;
            totalTime++;
        }
        return totalTime + "";
    }
    
    private static int comparePosition(Integer m, Integer n) {
        if (m > n) { return 1; }
        else if (m == n) { return 0; }
        else { return -1; }
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
            new BotTrust(filename).run();
        }
    }
}

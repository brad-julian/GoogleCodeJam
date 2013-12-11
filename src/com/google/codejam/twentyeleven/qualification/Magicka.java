/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.google.codejam.twentyeleven.qualification;

import com.google.codejam.CodeJamProblem;
import java.util.*;

/**
 *
 * @author BJulian
 */
public class Magicka extends CodeJamProblem {
    
    Magicka(String filename) {
        super(filename);
    }
    
    Map<Pair, String> combinations;
    Map<String, List<String>> opposites;
    
    List<String> elementList;
    
    private class Pair {
        private String a;
        private String b;
        
        Pair(String a, String b) {
            this.a = a;
            this.b = b;
        }
        
        boolean hasElement(String x) {
            return (x.equals(a)) || (x.equals(b));
        }
        
        @Override
        public int hashCode() {
            return a.hashCode()*b.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Pair other = (Pair) obj;
            return other.hasElement(a) && other.hasElement(b);
        }
    }
    
    @Override
    protected String solveIteration() {        
        combinations = new HashMap<Pair, String>();
        opposites = new HashMap<String, List<String>>();
        
        String input = fileScanner.nextLine();
        Scanner lineScan = new Scanner(input);
        
        elementList = new ArrayList<String>();
        
        int c = lineScan.nextInt();
        for (int i=0; i < c; i++) {
            String[] combo = lineScan.next().split("");
            combinations.put(new Pair(combo[1],combo[2]), combo[3]);
        }
        int d = lineScan.nextInt();
        for (int i=0; i < d; i++) {
            String[] oppPair  = lineScan.next().split("");
            List<String> oppEls;
            oppEls = opposites.containsKey(oppPair[1]) ?
                opposites.get(oppPair[1]) :
                new ArrayList<String>();
            oppEls.add(oppPair[2]);
            opposites.put(oppPair[1],oppEls);
            
            oppEls = opposites.containsKey(oppPair[2]) ?
                opposites.get(oppPair[2]) :
                new ArrayList<String>();
            oppEls.add(oppPair[1]);
            opposites.put(oppPair[2],oppEls);
        }
        
        int n = lineScan.nextInt();
        String[] elements = lineScan.next().split("");
        for (int i=1; i <= n; i++) {
            String element = elements[i];
            evalCombos(element);
            evalOpposites();
        }
        return elementList.toString();
    }
    
    private void evalCombos(String element) {
        Pair elPair = new Pair(lastElement(), element);
        if (combinations.containsKey(elPair)) {
            replaceLastElement(combinations.get(elPair));
        }
        else {
            elementList.add(element);
        }
    }
    
    private void evalOpposites() {
        String element = lastElement();
        if (opposites.containsKey(element)) {
            List<String> oppEls = opposites.get(element);
            for (String oppEl : oppEls) {
                if (elementList.contains(oppEl)) {
                    elementList.clear();
                }
            }
        }
    }
    
    private String lastElement() {
        return elementList.isEmpty() ? "" : elementList.get(elementList.size()-1);
    }
    
    private void replaceLastElement(String element) {
        elementList.remove(elementList.size()-1);
        elementList.add(element);
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
            new Magicka(filename).run();
        }
    }
}

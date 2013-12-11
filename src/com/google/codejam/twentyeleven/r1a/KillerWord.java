/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.google.codejam.twentyeleven.r1a;

import com.google.codejam.CodeJamProblem;
import java.util.*;

/**
 *
 * @author BJulian
 */
public class KillerWord extends CodeJamProblem {
    
    KillerWord(String filename) {
        super(filename);
    }
    
    private class Dictionary {
        Map<String, List<String>> wordLists = new HashMap<String, List<String>>();
        List<String> fullDictionary = new ArrayList<String>();
        
        void add(String word) {
            String wordLength = word.length()+"";
            List<String> listAtLength = wordLists.containsKey(wordLength) ?
                    wordLists.get(wordLength) : new ArrayList<String>();
            listAtLength.add(word);
            
            fullDictionary.add(word);
        }
        
        List<String> getWordsOfLength(int length) {
            return wordLists.get(length+"");
        }
    }
    
    Dictionary dictionary;
    List<String[]> letterLists;
        
    @Override
    protected String solveIteration() {        
        dictionary  = new Dictionary();
        
        
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
            new KillerWord(filename).run();
        }
    }
}

package com.google.codejam;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Brad Julian
 */
public abstract class CodeJamProblem {
    private static final boolean DEBUG = true;
    
    protected Scanner fileScanner;
    protected BufferedWriter fileWriter;
    
    protected int iterations;
    
    protected static final String CASE_PREFIX = "Case #%d: ";
    
    public CodeJamProblem() {
        throw new UnsupportedOperationException("An input file must be provided for the problem.");
    }
    
    public CodeJamProblem(String filename) {
        String pathPrefix = "./src/" + this.getClass().getPackage().getName().replace(".", "/") + "/io/";
        try {
            fileScanner = new Scanner(new File(pathPrefix+filename+".in"));
            fileWriter  = new BufferedWriter(new FileWriter(new File(pathPrefix+filename+".out")));
        } catch (FileNotFoundException fnfE) {
            System.err.println("Error encountered while instantiating the input reader.");
            System.err.println(fnfE);
        } catch (IOException ioE) {
            System.err.println("Error encountered while instantiating the output writer.");
            System.err.println(ioE);
        }
    }
    
    public void run() {
        iterations = this.parseOneIntLine();
        for (int i=1; i<=iterations; i++) {
            try {
                printSolution(i, this.solveIteration());
            } catch (IOException ioE) {
                System.err.println("Error encountered while writing the solution.");
                System.err.println(ioE);
            }
        }
        this.shutdown();
    }
    
    protected abstract String solveIteration();
    
    protected void printSolution(int caseNumber, String solution) throws IOException {
        String output = String.format(CASE_PREFIX, caseNumber) + solution + "\n";
        if (DEBUG) { System.out.print(output); }
        fileWriter.write(output);
    }
    
    protected void shutdown() {
        fileScanner.close();
        try {
            fileWriter.close();
        } catch (IOException ioE) {
            System.err.println("Error encountered trying to close the output writer.");
            System.err.println(ioE);
        }
    }
    
    protected int parseOneIntLine() {
        return Integer.parseInt(fileScanner.nextLine());
    }
    
}

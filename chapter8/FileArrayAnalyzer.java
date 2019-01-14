package chapter8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileArrayAnalyzer {

    public static void main(String[ ] args) throws FileNotFoundException {

        Scanner scan = new Scanner(System.in);

        System.out.print("Row Count: ");
        final int ROW_COUNT = scan.nextInt();
        System.out.print("Column Count: ");
        final int COLUMN_COUNT = scan.nextInt();
        double[][] data = new double[ROW_COUNT][COLUMN_COUNT];

        System.out.println("WARNING: Ensure row & column count match input data.");
        System.out.print("Enter input data file path: ");
        String inputFileName = scan.next( );
        File inputFile = new File(inputFileName);
        Scanner inputFilestrm = new Scanner(inputFile);

        for (int i = 0; i < ROW_COUNT; i++) {
            for (int j = 0; j < COLUMN_COUNT; j++) {
                data[i][j] = inputFilestrm.nextDouble();
            }
        }

        double sl = doTheThing(data, true);
        double ls = doTheThing(data, false);

        System.out.println("\nSmallest of the largest values in each row: " + sl);
        System.out.println("Largest of the smallest values in each column: " + ls);
        System.out.println("\nSL: " + sl + (sl > ls ? " > " : " < ") + "LS: " + ls);
    }

    private static double doTheThing(double[][] data, boolean max) {
        double output = max ? Double.MAX_VALUE : Double.MIN_VALUE; // Init output variable depending on usage
        for (int i = 0; i < (max ? data.length : data[0].length); i++) { // Iterate through either row or column
            double extrema = max ? data[i][0] : data[0][i]; // Choose a starting value for the extrema
            for (int j = 0; j < (max ? data[0].length : data.length); j++) { // Iterate through either column or row
                extrema = (max ? data[i][j] > extrema : data[j][i] < extrema) ? (max ? data[i][j] : data[j][i]) : extrema;
            } // Compare stored extrema to current value to check if larger or smaller, and set new extrema if ideal
            output = (max ? extrema < output : extrema > output) ? extrema : output; // Compares stored output to extrema
        }
        return output;
    }
}
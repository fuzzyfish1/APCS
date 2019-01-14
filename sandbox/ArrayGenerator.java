package sandbox;

import java.text.DecimalFormat;
import java.util.Random;

public class ArrayGenerator {

    private Random random = new Random();
    private DecimalFormat fmt = new DecimalFormat("0.00");

    public int[] generateIntegerArray(int size, int min, int max) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) array[i] = random.nextInt(Math.abs(max-min) + 1) + min;
        return array;
    }

    public int[][] generate2DIntegerArray(int rows, int columns, int min, int max) {
        int[][] array = new int[rows][columns];
        for (int i = 0; i < rows; i++) array[i] = generateIntegerArray(columns, min, max);
        return array;
    }

    public double[] generateDoubleArray(int size, double min, double max) {
        double[] array = new double[size];
        for (int i = 0; i < size; i++) array[i] = Double.parseDouble(fmt.format((max-min)*random.nextDouble() + min));
        return array;
    }

    public double[][] generate2DDoubleArray(int rows, int columns, double min, double max) {
        double[][] array = new double[rows][columns];
        for (int i = 0; i < rows; i++) array[i] = generateDoubleArray(columns, min, max);
        return array;
    }

    public String arrayToString(int[] array) {
        String output = "";
        for (int value : array) output += value + "\t";
        return output;
    }

    public String arrayToString(int[][] array) {
        String output = "";
        for (int[] row : array) output += arrayToString(row) + "\n";
        return output;
    }

    public String arrayToString(double[] array) {
        String output = "";
        for (double value : array) output += value + "\t";
        return output;
    }

    public String arrayToString(double[][] array) {
        String output = "";
        for (double[] row : array) output += arrayToString(row) + "\n";
        return output;
    }
}

package sandbox;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

public class FundOptimizerCSV {

    public static void main(String args[]) throws FileNotFoundException {

        double cost1, cost2, cost3, funds, tolerance;
        Scanner reader = new Scanner(System.in);
        DecimalFormat fmt = new DecimalFormat("0.00");
        PrintWriter writer = new PrintWriter(new File("data.csv"));

        System.out.println("Enter three equipment prices, amount of funds, and allowable funds remaining:");

        cost1 = reader.nextDouble();
        cost2 = reader.nextDouble();
        cost3 = reader.nextDouble();
        funds = reader.nextDouble();
        tolerance = reader.nextDouble();

        int max1 = (int)(funds/cost1);
        int max2 = (int)(funds/cost2);
        int max3 = (int)(funds/cost3);

        writer.println("Remainder, N1, N2, N3");
        for (int i = 0; i < max1; i++) {
            for (int j = 0; j < max2; j++) {
                for (int k = 0; k < max3; k++) {
                    double sum = cost1 * i + cost2 * j + cost3 * k;
                    if (sum <= funds && funds - sum <= tolerance && Math.abs(i - j) <= 50 &&
                            Math.abs(j - k) <= 50 && Math.abs(k - i) <= 50) {
                        writer.println(fmt.format(funds - sum) + ", " + i + ", " + j + ", " + k);
                    }
                }
            }
        }
        writer.close();
        System.out.println("CSV Generated");
    }
}

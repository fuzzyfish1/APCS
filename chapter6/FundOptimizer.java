package chapter6;

import java.text.DecimalFormat;
import java.util.Scanner;

public class FundOptimizer {

    public static void main(String args[]) {

        double cost1, cost2, cost3;
        double funds;
        double tolerance;
        Scanner reader = new Scanner(System.in);
        DecimalFormat fmt = new DecimalFormat("0.00");

        System.out.println("Enter three equipment prices, amount of funds, and allowable funds remaining:");

        cost1 = reader.nextDouble();
        cost2 = reader.nextDouble();
        cost3 = reader.nextDouble();
        funds = reader.nextDouble();
        tolerance = reader.nextDouble();

        int max1 = (int)(funds/cost1);
        int max2 = (int)(funds/cost2);
        int max3 = (int)(funds/cost3);

        System.out.println("Remainder, N1, N2, N3");
        for (int i = 0; i < max1; i++) {
            for (int j = 0; j < max2; j++) {
                for (int k = 0; k < max3; k++) {
                    double sum = 1.0*i*cost1 + 1.0*j*cost2 + 1.0*k*cost3;
                    if (inTolerance(funds,sum,tolerance) && Math.abs(i-j)<=50 && Math.abs(j-k)<=50 && Math.abs(k-i)<=50) {
                        System.out.println(fmt.format(funds - sum) + ", " + i + ", " + j + ", " + k);
                    }
                }
            }
        }
    }

    public static boolean inTolerance(double funds, double cost, double tolerance) {
        return cost <= funds && funds - cost <= tolerance;
    }
}

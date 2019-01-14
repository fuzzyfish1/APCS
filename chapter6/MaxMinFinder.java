package chapter6;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MaxMinFinder {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> valueList = new ArrayList<Integer>();
        int tempValue, sum = 0;
        double average;

        System.out.println("Enter an integer (0 to quit): ");

        while (scan.hasNextInt()) {
            tempValue = scan.nextInt();
            valueList.add(tempValue);
            sum += tempValue;
        }

        System.out.println();
        if (valueList.size() == 0) {
            System.out.println("No values were entered.");
        } else {
            average = 1.0 * sum / valueList.size();
            sum = 0;
            for (Integer value : valueList) { sum += Math.pow(value - average, 2); }
            double stDev = Math.sqrt(1.0 * sum / valueList.size());

            DecimalFormat fmt = new DecimalFormat("0.###");

            int tempMax = Integer.MIN_VALUE;
            int tempMin = Integer.MAX_VALUE;
            for (int value : valueList) {
                if (value > tempMax) tempMax = value;
                if (value < tempMin) tempMin = value;
            }

            System.out.println("The maximum value is: " + tempMax);
            System.out.println("The minimum value is: " + tempMin);
//            System.out.println("The average is " + fmt.format(average));
//            System.out.println("The population standard deviation is " + fmt.format(stDev));
        }

    }
}
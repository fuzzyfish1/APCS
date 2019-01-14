package chapter5;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class SetAnalyzer {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> valueList = new ArrayList<Integer>();
        int tempValue, sum = 0;
        double average;

        System.out.println("Enter an integer (0 to quit): ");
        tempValue = scan.nextInt();
        while (tempValue != 0) {
            valueList.add(tempValue);
            sum += tempValue;
            tempValue = scan.nextInt();
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
            System.out.println("The average is " + fmt.format(average));
            System.out.println("The population standard deviation is " + fmt.format(stDev));
        }

    }
}
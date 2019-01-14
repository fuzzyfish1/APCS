package chapter2;

import java.util.Scanner;

public class TripleAverage {

    public static void main(String args[]) {
        Scanner r = new Scanner(System.in);

        System.out.print("Enter the first score: ");
        int num1 = r.nextInt();
        System.out.print("Enter the second score: ");
        int num2 = r.nextInt();
        System.out.print("Enter the third score: ");
        int num3 = r.nextInt();
        double average = (num1 + num2 + num3) / 3.0;

        System.out.println("\nThe average of " + num1 + ", " + num2 + ", and " + num3 + " is " + average + ".");

        /** EXAMPLE OUTPUT
         *
         * Enter your first number: 2
         * Enter your second number: 3
         * Enter your third number: 4
         *
         * The average of 2, 3, and 4 is 3.0.
         *
         * Process finished with exit code 0
         */
    }
}

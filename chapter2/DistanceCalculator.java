package chapter2;

import java.util.Scanner;

/**
 * Calculates the distance between two points in cartesian space.
 */
public class DistanceCalculator {

    public static void main(String args[]) {
        Scanner r = new Scanner(System.in);

        int x1, y1, x2, y2;

        System.out.print("What is the x value of your first point? ");
        x1 = r.nextInt();
        System.out.print("What is the y value of your first point? ");
        y1 = r.nextInt();
        System.out.print("What is the x value of your second point? ");
        x2 = r.nextInt();
        System.out.print("What is the y value of your second point? ");
        y2 = r.nextInt();
        r.close();

        double distance = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));

        System.out.print("\nThe distance between points (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ") is ");
        System.out.printf("%.2f%n", distance);

        /** EXAMPLE OUTPUT
         *
         * What is the x value of your first point? 0
         * What is the y value of your first point? 5
         * What is the x value of your second point? 6
         * What is the y value of your second point? 5
         *
         * The distance between points (0, 5) and (6, 5) is 6.00
         *
         * Process finished with exit code 0
         *
         * What is the x value of your first point? -4
         * What is the y value of your first point? 6
         * What is the x value of your second point? 8
         * What is the y value of your second point? -5
         *
         * The distance between points (-4, 6) and (8, -5) is 16.28
         *
         * Process finished with exit code 0
         */
    }
}

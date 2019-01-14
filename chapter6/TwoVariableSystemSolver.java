package chapter6;

import java.util.Scanner;

public class TwoVariableSystemSolver {

    public static void main(String args[]) {

        Scanner r = new Scanner(System.in);

        System.out.println("Enter EQ1-X,EQ1-Y,EQ1-SOL,EQ2-X,EQ2-Y,EQ2-SOL,Min-X,Max-X,Min-Y,Max-Y");
        System.out.print("Delimit integers with spaces: ");

        int eq1x = r.nextInt();
        int eq1y = r.nextInt();
        int eq1sol = r.nextInt();
        int eq2x = r.nextInt();
        int eq2y = r.nextInt();
        int eq2sol = r.nextInt();
        int xMin = r.nextInt();
        int xMax = r.nextInt();
        int yMin = r.nextInt();
        int yMax = r.nextInt();

        for (int x=xMin; x<=xMax; x++) {
            for (int y=yMin; y<=yMax; y++) {
                if (eq1x*x+eq1y*y==eq1sol && eq2x*x+eq2y*y==eq2sol) {
                    System.out.println("\nX: " + x + ", Y: " + y);
                }
            }
        }
    }
}

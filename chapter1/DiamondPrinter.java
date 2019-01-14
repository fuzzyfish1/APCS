package chapter1;

import java.util.Scanner;

public class DiamondPrinter {

    public static void printLine(int currHeight, int totalHeight) {
        for(int spaces = 0; spaces < totalHeight - currHeight; spaces++) {
            System.out.print(" ");
        }

        for(int stars = 0; stars < currHeight; stars++) {
            System.out.print("* ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.print("Diamond Height (Odds Only): ");

        int diamondHeight = s.nextInt();

        for(int height = 1; height <= diamondHeight/2+1; height++) {
            printLine(height, diamondHeight);
        }

        for(int height = diamondHeight/2; height > 0; height--) {
            printLine(height, diamondHeight);
        }
    }

    /*
    Output

        Diamond Height (Odds Only): 7
          *
         * *
        * * *
       * * * *
        * * *
         * *
          *
     */
}

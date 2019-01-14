package chapter6;

import java.util.Scanner;

public class MaximumProfit {

    public static void main(String args[]) {
        Scanner r = new Scanner(System.in);

        System.out.println("Enter: Fund Value");
        double fundValue = r.nextDouble();
        System.out.println("Enter: Buy Price One, Buy Price Two, Buy Price Three");
        double buyPriceOne = r.nextDouble();
        double buyPriceTwo = r.nextDouble();
        double buyPriceThree = r.nextDouble();
        System.out.println("Enter: Sell Price One, Sell Price Two, Sell Price Three");
        double sellPriceOne = r.nextDouble();
        double sellPriceTwo = r.nextDouble();
        double sellPriceThree = r.nextDouble();
        double tempProfit = 0;
        int[] optimalSet = new int[3];

        for (int i = 0; i <= (int)(fundValue/buyPriceOne); i++) {
            for (int j = 0; j <= (int)(fundValue/buyPriceTwo); j++) {
                for (int k = 0; k <= (int)(fundValue/buyPriceThree); k++) {
                    double currProfit = i*(sellPriceOne-buyPriceOne)+j*(sellPriceTwo-buyPriceTwo)+k*(sellPriceThree-buyPriceThree);
                    if (i*buyPriceOne+j*buyPriceTwo+k*buyPriceThree <= fundValue &&
                            currProfit > tempProfit) {
                        optimalSet[0] = i;
                        optimalSet[1] = j;
                        optimalSet[2] = k;
                        tempProfit = currProfit;
                    }
                }
            }
        }
        System.out.println("Item 1: " + optimalSet[0] + ", Item 2: " + optimalSet[1] + ", Item 3: " + optimalSet[2] +
                ", Profit: " + (tempProfit));
    }
}

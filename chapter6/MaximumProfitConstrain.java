package chapter6;

public class MaximumProfitConstrain {

    public static void main(String args[]) {
        final int M1_TOTAL_HOURS = 450;
        final int M1_TABLE_HOURS = 7;
        final int M1_CHAIR_HOURS = 4;
        final int M2_TOTAL_HOURS = 250;
        final int M2_TABLE_HOURS = 5;
        final int M2_CHAIR_HOURS = 3;
        final int TABLE_PROFIT = 28;
        final int CHAIR_PROFIT = 21;
        final int CHAIR_TO_TABLE_RATIO = 4;
        int tempProfit = 0;
        int[] optimalSet = new int[2];

        for (int t = 0; t < Math.max(M1_TOTAL_HOURS/M1_TABLE_HOURS, M2_TOTAL_HOURS/M2_TABLE_HOURS); t++) {
            for (int c = 0; c < Math.max(M1_TOTAL_HOURS/M1_CHAIR_HOURS, M2_TOTAL_HOURS/M2_CHAIR_HOURS); c++) {
                if (t*M1_TABLE_HOURS+c*M1_CHAIR_HOURS < M1_TOTAL_HOURS &&
                        t*M2_TABLE_HOURS+c*M2_CHAIR_HOURS < M2_TOTAL_HOURS &&
                        t*TABLE_PROFIT+c*CHAIR_PROFIT > tempProfit) { /*&&
                        t*CHAIR_TO_TABLE_RATIO == c) { */
                    optimalSet[0] = t;
                    optimalSet[1] = c;
                    tempProfit = t*TABLE_PROFIT+c*CHAIR_PROFIT;
                }
            }
        }
        System.out.println("Tables: " + optimalSet[0] + ", Chairs: " + optimalSet[1] + ", Maximum Profit: " + tempProfit);
    }
}

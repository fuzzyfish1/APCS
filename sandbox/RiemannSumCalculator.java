package sandbox;

import java.text.DecimalFormat;

public class RiemannSumCalculator {

    static DecimalFormat fmt = new DecimalFormat("0.00");

    public enum SumType {
        LEFT,
        RIGHT,
        MID
    }

    public static double calc(double min, double max, int n, SumType type) {
        double dx = (max-min)/(1.0*n);
        double sum = 0;
        for (int i = 0; i < n; i++) {
            switch (type) {
                case LEFT:
                    sum += function(min + (dx*i));
                    break;
                case RIGHT:
                    sum += function(min + (dx*(i+1)));
                    break;
                case MID:
                    sum += function((min + (0.5*dx)) + (dx*i));
            }
            if (i%10000000 == 0) System.out.println("Progress : " + fmt.format(100*((1.0*i)/(1.0*n))) + "%");
        }
        return dx*sum;
    }

    public static void main(String args[]) {
        System.out.println("LEFT: " + calc(0, Math.PI, Integer.MAX_VALUE, SumType.MID));
    }

    public static double function(double x) {
        return Math.sin(x);
    }


}

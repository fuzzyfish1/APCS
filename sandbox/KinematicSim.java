package sandbox;

import java.text.DecimalFormat;

public class KinematicSim {

    private double xAccel;
    private double yAccel;
    private double xInitVelocity = 0;
    private double yInitVelocity = 0;
    private DecimalFormat fmt = new DecimalFormat();

    public KinematicSim(double mass, double fxpositive, double fxnegative, double fypositive, double fynegative) {
        xAccel = (fxpositive - fxnegative) / mass;
        yAccel = (fypositive - fynegative) / mass;
    }

    public void setAdditionalConditions(double xInitVelocity, double yInitVelocity) {
        this.xInitVelocity = xInitVelocity;
        this.yInitVelocity = yInitVelocity;
    }

    public double[][] calculateXInterval(double t0, double t1, double tStep) {
        int totalIterations = (int)((t1 - t0) / tStep) + 1;
        double[][] array = new double[totalIterations][4];

        for(int i = 0; i < totalIterations; i++) {
            array[i] = calculateX(t0);
            t0 += tStep;
        }

        return array;
    }

    public double[][] calculateYInterval(double t0, double t1, double tStep) {
        int totalIterations = (int)((t1 - t0) / tStep) + 1;
        double[][] array = new double[totalIterations][4];

        for(int i = 0; i < totalIterations; i++) {
            array[i] = calculateY(t0);
            t0 += tStep;
        }

        return array;
    }

    public double[] calculateX(double t) {
        double[] tdva = new double[4];
        tdva[0] = t;
        tdva[1] = xInitVelocity * t + 0.5 * xAccel * t * t;
        tdva[2] = xInitVelocity + xAccel * t;
        tdva[3] = xAccel;
        return tdva;
    }

    public double[] calculateY(double t) {
        double[] tdva = new double[4];
        tdva[0] = t;
        tdva[1] = yInitVelocity * t + 0.5 * yAccel * t * t;
        tdva[2] = yInitVelocity + yAccel * t;
        tdva[3] = yAccel;
        return tdva;
    }

    public String arrayToString(double[] tdva) {
        return fmt.format(tdva[0]) + "," + fmt.format(tdva[1]) + "," + fmt.format(tdva[2]) + "," + fmt.format(tdva[3]);
    }

    public String arrayToString(double[][] array) {
        String output = "Time(s),Displacement(m),Velocity(m/s),Acceleration(m/s^2)\n";

        for (double[] tdva: array) {
            output += arrayToString(tdva) + "\n";
        }

        return output;
    }
}

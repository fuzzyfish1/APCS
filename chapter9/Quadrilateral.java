package chapter9;

import java.text.DecimalFormat;

public class Quadrilateral {

    protected double a, b, c, d, A, B, C, D, s;

    private DecimalFormat fmt = new DecimalFormat("0.00");

    /**
     * Creates a quadrilateral.
     *
     * Angles are to the left of the side lengths:
     *
     * segment AB = length a
     * segment BC = length b
     * segment CD = length c
     * segment DA = length d
     *
     * @param lengths array of 4 side lengths
     * @param angles array of 4 angles in degrees
     */
    public Quadrilateral(double[] lengths, double[] angles) {
        a = lengths[0];
        b = lengths[1];
        c = lengths[2];
        d = lengths[3];
        A = angles[0];
        B = angles[1];
        C = angles[2];
        D = angles[3];

        s = (a + b + c + d) / 2;
    }

    public boolean isQuad() {
        return Math.abs(A + B + C + D - 360) < 1E-6;
    }

    public double getArea() {
        double B = Math.toRadians(this.B);
        double D = Math.toRadians(this.D);
        double squarea = (s-a)*(s-b)*(s-c)*(s-d) - a*b*c*d*Math.pow(Math.cos((B+D)/2),2);
        return Math.sqrt(squarea);
    }

    @Override
    public String toString() {
        return "Lengths: \ta:" + fmt.format(a) + " b:" + fmt.format(b) + " c:" + fmt.format(c) +" d:" + fmt.format(d) + "\n" +
                "Angles: \tA:" + fmt.format(A) + " B:" + fmt.format(B) + " C:" + fmt.format(C) +" D:" + fmt.format(D) + "\n" +
                "Is Quad: " + this.isQuad() + "\n" +
                "Area: " + fmt.format(this.getArea());
    }
}

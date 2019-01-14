package chapter9;

public class Trapezoid extends Quadrilateral {

    public Trapezoid(double[] lengths, double[] angles) {
        super(lengths, angles);
    }

    public boolean isTrapezoid() {
        return a == c || b == d;
    }
}

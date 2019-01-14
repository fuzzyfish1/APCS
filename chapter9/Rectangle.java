package chapter9;

public class Rectangle extends Parallelogram {

    public Rectangle(double[] lengths, double[] angles) {
        super(lengths, angles);
    }

    public boolean isRectangle() {
        return isParallelogram() && A == 90 && B == 90;
    }
}

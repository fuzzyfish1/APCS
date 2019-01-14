package chapter9;

public class Rhombus extends Parallelogram {

    public Rhombus(double[] lengths, double[] angles) {
        super(lengths, angles);
    }

    public boolean isRhombus() {
        return isParallelogram() && a == c && b == d;
    }
}

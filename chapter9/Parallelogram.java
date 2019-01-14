package chapter9;

public class Parallelogram extends Quadrilateral {

    public Parallelogram(double[] lengths, double[] angles) {
        super(lengths, angles);
    }

    public boolean isParallelogram() {
        return A == C || B == D;
    }
}

package robots;

public class Vector2d {

    private final double x;
    private final double y;

    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return x value
     */
    public double getX() {
        return x;
    }

    /**
     * @return y value
     */
    public double getY() {
        return y;
    }

    /**
     * @return length of vector
     */
    public double getMagnitude() {
        return Math.sqrt(x * x + y * y);
    }

    /**
     * @return direction of vector in radians
     */
    public double getDirection() {
        return MathUtil.wrapRad(Math.atan2(y, x));
    }

    /**
     * @param other vector to add
     * @return sum of vectors
     */
    public Vector2d add(Vector2d other) {
        return new Vector2d(x + other.x, y + other.y);
    }

    /**
     * @param scale scaling factor
     * @return scaled vector
     */
    public Vector2d scale(double scale) {
        return new Vector2d(x * scale, y * scale);
    }

    /**
     * @return vector of unit length in same direction
     */
    public Vector2d normalize() {
        return scale(1 / getMagnitude());
    }

    /**
     * @param target desired length
     * @return vector of target length in same direction
     */
    public Vector2d normalize(double target) {
        return scale(target / getMagnitude());
    }

    /**
     * @param angle angle in radians
     * @return rotated vector
     */
    public Vector2d rotate(double angle) {
        return new Vector2d(x * Math.cos(angle) - y * Math.sin(angle), x * Math.sin(angle) + y * Math.cos(angle));
    }

    /**
     * @param other vector to multiply
     * @return dot product
     */
    public double dot(Vector2d other) {
        return x * other.x + y * other.y;
    }

    /**
     * @param other vector to cross
     * @return determinant
     */
    public double determinant(Vector2d other) {
        return x * other.y - y * other.x;
    }

    /**
     * @return vector reflected into 1st quadrant
     */
    public Vector2d abs() {
        return new Vector2d(Math.abs(x), Math.abs(y));
    }

    @Override
    public Vector2d clone() {
        return new Vector2d(x, y);
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", x, y);
    }

}

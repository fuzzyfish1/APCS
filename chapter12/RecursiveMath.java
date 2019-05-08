package chapter12;

public class RecursiveMath {

    private static final double EPSILON = 1E-14;

    /**
     * Checks whether or not a string is a palindrome (reads the same both directions).
     *
     * <p>1. If the string is either 0 or 1 characters, return true.
     * <p>2. If the first and last characters are equal, remove the first and last characters of the string and
     * return to (1).
     *
     * @param s string to be tested
     * @return whether or not the string is a palindrome
     */
    public static final boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return true;
        return s.charAt(0) == s.charAt(s.length() - 1) && isPalindrome(s.substring(1, s.length() - 1));
    }

    /**
     * Finds the GCF (Greatest Common Factor) of two values.
     *
     * <p>1. If a is greater than b, exchange a and b.
     * <p>2. Divide a by b and get the remainder, r.
     * <p>3. If r is equal to 0, return b as the GCF of a and b.
     * <p>4. Replace a with b and b with r and return to (1).
     *
     * @param a first value
     * @param b second value
     * @return GCF of the values
     */
    public static final int gcf(int a, int b) {
        int r = a > b ? a % b : b % a;
        return r == 0 ? b : gcf(b, r);
    }

    /**
     * Finds the closest zero of a function to a given estimate.
     *
     * <p>1. The next estimate is equal to the x-intercept of the tangent line at the last estimate.
     * <p>2. If the change between the next and last estimate is negligible, then return the next estimate.
     * <p>3. Replace the last estimate with the next estimate and return to (1).
     *
     * @param function function to find the zeros of
     * @param estimate initial guess at the location of a zero
     * @return value of the zero closest to estimate
     */
    public static final double findClosestZero(Function function, double estimate) {
        double next = estimate - (function.f(estimate) / function.f2(estimate));
        if (Math.abs(next - estimate) < EPSILON) return next;
        return findClosestZero(function, next);
    }

    /**
     * Finds a zero within a given interval using Intermediate Value Theorem. As such, one bound must return a value
     * above the x-axis and the other must be below. Making the bounds as specific as possible helps with this.
     *
     * <p>1. If the absolute y value halfway between the bounds is negligible, return the corresponding x.
     * <p>2. If the y value at {@param a} and the y value halfway between the bounds have different signs, {@param b}
     * is equal to halfway between the previous bounds. Return to (1).
     * <p>3. {@param a} is equal to halfway between the previous bounds. Return to (1).
     *
     * @param func function to find the zeros of
     * @param a first bound
     * @param b second bound
     * @return value of a zero within bounds
     */
    public static final double findZeroInterval(Function func, double a, double b) {
        double halfX = (a + b) / 2.0;
        if (Math.abs(func.f(halfX)) < EPSILON) return halfX;
        if (func.f(halfX) * func.f(a) < 0.0) return findZeroInterval(func, a, halfX);
        else return findZeroInterval(func, halfX, b);
    }

    /**
     * Recursively finds the value of an infinite nested radical sum.
     *
     * <p>1. If the absolute difference between the current and last values is negligible, return the square root of
     * the current value.
     * <p>2. The last value is equal to the current value.
     * <p>3. Current value is equal to the initial value plus the square root of the current value. Return to (1).
     *
     * @param value value to put inside the radical
     * @return nested radical sum
     */
    public static final double nestedRadicalSum(double value) {
        return nestedRadicalSum(value, value, 0.0);
    }

    private static final double nestedRadicalSum(double value, double initValue, double lastValue) {
        System.out.println("VAL: " + value);
        if (Math.abs(value - lastValue) < EPSILON) return Math.sqrt(value);
        lastValue = value;
        return nestedRadicalSum(initValue + Math.sqrt(value), initValue, lastValue);
    }

    public static final double newNestedRadical(double value, double initValue) {
        value = Math.sqrt(value + initValue);
//        System.out.println("VAL: " + value);
        if (value - Math.sqrt(value + initValue) < EPSILON) return value;
        return newNestedRadical(value, initValue);
    }

    /**
     * Calculates the minimum amount of moves required to solve a Tower of Hanoi.
     *
     * <p>1. If the number of disks is equal to 0, return 0.
     * <p>2. Subtract one from the number of disks and return to (1). Multiply this result by 2, and then add 1.
     *
     * @param n number of disks
     * @return minimum number of moves
     */
    public static final int hanoiMoves(int n) {
        if (n == 0) return 0;
        return 2 * hanoiMoves(n - 1) + 1;
    }

    /**
     * Calculates {@param a} to the power of {@param b}.
     *
     * @param a number to bring to some power
     * @param b power
     * @return {@param a} to the power of {@param b}
     */
    public static final double pow(double a, int b) {
        if (b == 0) {
            if (a == 0) return Double.NaN;
            return 1;
        } else if (b > 0) {
            if (b%2 == 0) return pow(a, b/2) * pow(a, b/2);
            return a * pow(a, b-1);
        }
        return 1.0 / pow(a, -b);
    }

}

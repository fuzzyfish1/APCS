package chapter1;

public class HelloPrinter {

    /**
     * Checks if an integer is even.
     *
     * @param num The number to be checked
     * @return boolean
     */

    public static boolean isEven(int num) {
        while (num > 1) { num -= 2; }
        return num == 0;
    }

    public static boolean isPrime(int num) {
        return false;
    }

    public static void main(String args[]) {

        // Prints "Hello World!" to the console.
        System.out.println("\"Hello World!\"\nMy name is Connor Sutton.\nI am a student at Oswego High School.");

        // Iterates through numbers 1 through 20 and determines if each is even.
        for(int i = 1; i < 20; i++) {
            System.out.println("Is " + i + " an even number? " + (isEven(i) ? "yes" : "no"));
        }
    }
}

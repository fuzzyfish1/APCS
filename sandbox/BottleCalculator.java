package sandbox;

public class BottleCalculator {

    public static void main(String args[]) {
        final int DOLLARS = 20;
        final int DOLLARS_PER_BOTTLE = 2;
        final int BODIES_PER_BOTTLE = 2;
        final int CAPS_PER_BOTTLE = 4;

        int fullBottlesT = DOLLARS/DOLLARS_PER_BOTTLE;
        int fullBottlesC = fullBottlesT;
        System.out.println(fullBottlesC);
        int bodies = 0;
        int caps = 0;

        while (fullBottlesC != 0) {
            bodies += fullBottlesC;
            caps += fullBottlesC;
            fullBottlesC = 0;

            while (bodies/BODIES_PER_BOTTLE != 0) {
                fullBottlesC++;
                bodies -= BODIES_PER_BOTTLE;
            }

            while (caps/CAPS_PER_BOTTLE != 0) {
                fullBottlesC++;
                caps -= CAPS_PER_BOTTLE;
            }

            fullBottlesT += fullBottlesC;
        }

        System.out.println("Total Bottles: " + fullBottlesT);
        System.out.println("Current Bottles (Should be 0): " + fullBottlesC);
        System.out.println("Remaining Bodies: " + bodies);
        System.out.println("Remaining Caps: " + caps);
    }
}

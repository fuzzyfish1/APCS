package sandbox;

import java.util.Scanner;

public class CopyMachine {

    private int[] paperCounts = {0,0,0,0}; // An array to store the amount of paper in each drawer
    private int activeDrawer = 1; // An integer to store the active drawer number
    private final int RELOAD_AMOUNT = 20;
    private Scanner scan = new Scanner(System.in);

    /**
     * Class constructor that passes amount of paper in each drawer.
     *
     * @param paperCounts An integer array of length 4
     */
    public CopyMachine(int[] paperCounts) {
        if (paperCounts.length == 4) {
            this.paperCounts = paperCounts;
        } else {
            System.out.print("[ERROR]: Invalid Parameter");
        }
    }

    /**
     * Default class constructor that initializes all paper to 0.
     */
    public CopyMachine() {}

    /**
     * Sets the active drawer.
     *
     * @param drawer The number of the desired drawer, 1-4.
     */
    public void setActiveDrawer(int drawer) {
        activeDrawer = loopingRange(drawer, 1, 4);
    }

    /**
     * Adds an amount of paper to a specified drawer.
     *
     * @param amount the amount of paper to be loaded
     * @param drawer the drawer to load into
     */
    public void loadPaper(int amount, int drawer) {
        if (drawer > 0 && drawer < 5)
            paperCounts[drawer-1] += amount;
        else
            System.out.println("[ERROR]: Invalid Drawer");
    }

    /**
     * Returns an integer array containing the amount of paper in each drawer.
     *
     * @return the amount of paper in each drawer
     */
    public int[] getPaperCounts() {
        return paperCounts;
    }

    /**
     * Prints the paper remaining in each drawer in a nice format.
     */
    public void printPaperRemaining() {
        for (int i = 0; i < paperCounts.length; i++)
            System.out.println("\nDrawer " + (i+1) + ": " + paperCounts[i]);
    }

    /**
     * Simulates copying a document an amount of times equal to count.
     *
     * @param count the amount of copies to make
     */
    public void copy(int count) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            if (paperCounts[activeDrawer-1] > 0) {
                paperCounts[activeDrawer-1]--;
                System.out.println("Copying page " + (i + 1) + "/" + count);
            } else if (nextDrawer() != 0){
                System.out.println("Drawer " + loopingRange(activeDrawer-1, 1, 4) +
                        " is empty. Advancing to drawer " + activeDrawer + ".");
                i--;
            } else {
                System.out.println("Out of paper. Reload active drawer? Y/N");
                String input = scan.nextLine();
                if (input.toUpperCase().equals("Y")) {
                    System.out.println("Reloading drawer " + activeDrawer + " with " + RELOAD_AMOUNT + " pieces of paper...");
                    loadPaper(RELOAD_AMOUNT, activeDrawer);
                    System.out.println("Done. Resuming print job...");
                } else if (input.toUpperCase().equals("N")) {
                    System.out.println("Ending current print job...");
                    break;
                } else {
                    System.out.println("Invalid input. Ending current print job...");
                    break;
                }
                i--;
            }
            Thread.sleep(200);
        }
        System.out.println("Print job complete.");
        printPaperRemaining();
    }

    /**
     * Advances the active drawer to the next available with paper.
     *
     * @return the number of the now active drawer
     */
    private int nextDrawer() {
        for (int i = 0; i < 3; i++) {
            if (getPaperCounts()[loopingRange(i+activeDrawer, 0, 3)] > 0) {
                setActiveDrawer(i+activeDrawer+1);
                return loopingRange(i+activeDrawer+1, 1, 4);
            }
        }
        return 0;
    }

    /**
     * Constrains an input to a specified range by looping numbers outside of the range to the opposite side.
     *
     * @param input the integer to be constrained
     * @param min the minimum acceptable value
     * @param max the maximum acceptable value
     * @return the constrained integer
     */
    private int loopingRange(int input, int min, int max) {
        while (input > max) input -= (max-min);
        while (input < min) input += (max-min);
        return input;
    }
}
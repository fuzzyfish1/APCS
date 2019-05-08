package chapter14;

public class SelectionSorting {

    public static double[] swap(double[] array, int a, int b) {
        double temp = array[a];
        array[a] = array[b];
        array[b] = temp;
        return array;
    }

    public static int findSmallest(double[] array, int start) {
        int sIndex = start;
        for (int i = start; i < array.length; i++) {
            if (array[i] < array[sIndex]) { sIndex = i; }
        }
        return sIndex;
    }

    public static double[] selectionSortR(double[] array, int start) {
        if (start == array.length) { return array; }
        int sIndex = findSmallest(array, start);
        array = swap(array, start, sIndex);
        return selectionSortR(array, start + 1);
    }

    public static double[] recursiveSelectionSortRevised(double[] array, int start) {
        if (start == array.length) { return array; }
        int s = start;
        for (int i = start; i < array.length; i++) {
            if (array[i] < array[s]) s = i;
        }
        double temp = array[start];
        array[start] = array[s];
        array[s] = temp;
        return recursiveSelectionSortRevised(array, start + 1);
    }

    public static double[] selectionSortL(double[] array) {
        for (int i = 0; i < array.length; i++) {
            int s = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[s]) s = j;
            }
            double temp = array[i];
            array[i] = array[s];
            array[s] = temp;
        }
        return array;
    }

    public static void main(String args[]) {
        long lastTime = 0;
        long currTime = 0;

        lastTime = System.nanoTime();
        double[] sorted = selectionSortR(new double[]{44.7,30.2,36.5,19.3,14.4,60.9}, 0);
        currTime = System.nanoTime();

        System.out.println("Recursive Sort Time: " + (currTime - lastTime) + " ns");

        lastTime = System.nanoTime();
        double[] sortedL = selectionSortL(new double[]{44.7,30.2,36.5,19.3,14.4,60.9});
        currTime = System.nanoTime();

        System.out.println("Loop Sort Time: " + (currTime - lastTime) + " ns");

//        for (double val : sorted) {
//            System.out.print(val + ", ");
//        }
//
//        for (double val : sortedL) {
//            System.out.print(val + ", ");
//        }
    }
}

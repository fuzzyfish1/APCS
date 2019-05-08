package chapter14;

import sandbox.ArrayGenerator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BinarySearching {

    public static int binarySearch(int[] arr, int a, int b, int x) {
        if (a > b || b >= arr.length || a < 0) return -1;
        int mid = (a + b) / 2;
        if (arr[mid] == x) return mid;
        if (arr[mid] > x) return binarySearch(arr, a, mid, x);
        return binarySearch(arr, mid, b, x);
    }

    public static int recursiveLinearSearch(int[] arr, int a, int b, int x) {
        if (arr[a] == x) return a;
        if (arr[b] == x) return b;
        return recursiveLinearSearch(arr, a + 1, b - 1, x);
    }

    public static void main(String args[]) {
        ArrayGenerator gen = new ArrayGenerator();
        int[] unsorted = gen.generateIntegerArray(20, 1, 100);
        System.out.println(Arrays.toString(unsorted));
        long currTime;
        for (int i = 0; i < unsorted.length; i++) {
            currTime = System.nanoTime();
            recursiveLinearSearch(unsorted, 0, unsorted.length - 1, unsorted[i]);
            System.out.println("Position " + i + " Time: " + (System.nanoTime() - currTime) + "ns");
        }
    }

}


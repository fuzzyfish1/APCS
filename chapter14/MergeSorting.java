package chapter14;

import java.util.Arrays;

public class MergeSorting {

    public static void sort(double arr[], int a, int b) {
        if (a < b) {
            // Find the middle point
            int m = (a + b) / 2;

            // Sort first and second halves
            sort(arr, a, m);
            sort(arr , m + 1, b);

            // Merge the sorted halves
            merge(arr, a, m, b);
        }
    }

    public static void merge(double arr[], int a, int m, int b) {
        // Find sizes of two subarrays to be merged
        int n1 = m - a + 1;
        int n2 = b - m;

        /* Create temp arrays */
        double L[] = new double[n1];
        double R[] = new double[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[a + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = a;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String args[]) {
        double[] arr = new double[]{19.2, 14.6, 14.2, 70.4, 12.7, 4.0, 1.9};
        sort(arr, 0, 5);
        System.out.println(Arrays.toString(arr));
    }
}

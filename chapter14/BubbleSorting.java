package chapter14;

import java.util.Arrays;

public class BubbleSorting {

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String args[]) {
        int[] arr = new int[]{9,10,11,4,6,2,12,10,3};
        int[] arr2 = new int[]{134,12,19,203,1234,12,34,58,1,93};
        int[] arr3 = new int[]{16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0};
        bubbleSort(arr);
        bubbleSort(arr2);
        bubbleSort(arr3);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }
}

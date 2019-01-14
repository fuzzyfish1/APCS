package chapter8;

public class BubbleSort {

    public static void main(String args[]) {

        int[] array = {428,921,3,3,384,234,56,2345,83,21,12,84};

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                int temp = array[j];
                if (j != array.length - 1 && temp > array[j + 1]) {
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        for (int num : array) {
            System.out.print(num + ", ");
        }
    }
}

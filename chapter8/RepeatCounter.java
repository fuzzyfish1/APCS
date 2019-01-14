package chapter8;

import java.util.Arrays;
import java.util.Scanner;

public class RepeatCounter {

    public static void main(String args[]) {

        Scanner r = new Scanner(System.in);
        System.out.println("Enter whitespace delimited integers (EX: 3 -6 11 ...)");
        String stringInput = r.nextLine();
        r = new Scanner(stringInput);

        int intCount = 0;
        while (r.hasNextInt()) {
            r.nextInt();
            intCount++;
        }

        r = new Scanner(stringInput);
        int[] array = new int[intCount];

        for (int i = 0; i < intCount; i++) array[i] = r.nextInt();
        r.close();

        Arrays.sort(array);

        for (int i = 0; i < intCount;) {
            int count = 1;
            while (i < intCount-1 && array[i+count] == array[i]) count++;
            System.out.println(array[i] + ": " + count);
            i += count;
        }
    }
}

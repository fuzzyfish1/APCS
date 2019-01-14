package chapter3;

import java.util.Scanner;

public class StringCenterPunch {

    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter a string to center-punch: ");
        String input = reader.nextLine();
        int length = input.length();
        System.out.print("Center-punched output: " + input.substring(length/2-1, length/2+2));
    }
}

package chapter3;

import java.util.Scanner;

public class StringShaver {

    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter a string to shave: ");
        String input = reader.nextLine();
        System.out.print("Shaved output: " + input.substring(1, input.length()-1));
    }
}

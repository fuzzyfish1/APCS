package chapter5;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class TicketPriceCalculator {

    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        NumberFormat currencyFmt = NumberFormat.getCurrencyInstance();
        DecimalFormat decimalFormat = new DecimalFormat(".00");

        double REG_PRICE = 7.95;
        double TAX_RATE = 0.06;

        System.out.println("~~Ticket Price Calculator~~");
        System.out.print("How many people aged 0 - 2? ");
        int age0_2 = reader.nextInt();
        System.out.print("How many people aged 3 - 6? ");
        int age3_6 = reader.nextInt();
        System.out.print("How many people aged 7 - 11? ");
        int age7_11 = reader.nextInt();
        System.out.print("How many people aged 12 - 18? ");
        int age12_18 = reader.nextInt();
        System.out.print("How many people aged 19 - 22? ");
        int age19_22 = reader.nextInt();
        System.out.print("How many people aged 23 - 64? ");
        int age23_64 = reader.nextInt();
        System.out.print("How many people aged 65+? ");
        int age65plus = reader.nextInt();

        double subtotal = age3_6*REG_PRICE*0.1 + age7_11*REG_PRICE*0.3 +
                age12_18*REG_PRICE*0.5 + age19_22*REG_PRICE*0.7 +
                age23_64*REG_PRICE*1.0 + age65plus*REG_PRICE*0.6;

        if (age0_2 + age3_6 + age65plus > age7_11 + age12_18 + age19_22 + age23_64) { subtotal *= 0.85; }

        double tax = subtotal * TAX_RATE;
        double total = Double.parseDouble(decimalFormat.format(subtotal)) + Double.parseDouble(decimalFormat.format(tax));

        System.out.println("\nSubtotal: " + currencyFmt.format(subtotal));
        System.out.println("Tax: " + currencyFmt.format(tax));
        System.out.println("Total: " + currencyFmt.format(total));

        /**
         * OUTPUT
         * ~~Ticket Price Calculator~~
         * How many people aged 0 - 2? 5
         * How many people aged 3 - 6? 2
         * How many people aged 7 - 11? 10
         * How many people aged 12 - 18? 10
         * How many people aged 19 - 22? 5
         * How many people aged 23 - 64? 5
         * How many people aged 65+? 20
         *
         * Subtotal: $228.16
         * Tax: $13.69
         * Total: $241.85
         *
         * Process finished with exit code 0
         *
         * OUTPUT
         * ~~Ticket Price Calculator~~
         * How many people aged 0 - 2? 0
         * How many people aged 3 - 6? 2
         * How many people aged 7 - 11? 14
         * How many people aged 12 - 18? 3
         * How many people aged 19 - 22? 8
         * How many people aged 23 - 64? 12
         * How many people aged 65+? 7
         *
         * Subtotal: $220.21
         * Tax: $13.21
         * Total: $233.42
         *
         * Process finished with exit code 0
         */
    }
}

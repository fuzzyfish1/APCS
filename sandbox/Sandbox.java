package sandbox;

import chapter9.Employee;
import chapter9.Executive;
import chapter9.Manager;

public class Sandbox {

    public static void main(String args[]) {
        Employee john = new Employee("John Smith", 40320.0);
        Employee jill = new Manager("Jill Ryker", 84560.0, "Accounting");
        Employee max = new Executive("Max Tough", 122430.0, "Marketing");

        System.out.println(john);
        System.out.println(jill);
        System.out.println(max);
    }

}
package chapter4;

public class CarTest {

    public static void main(String args[]) {
        Car carOne = new Car("Mercury", "Pilot", 2007);
        Car carTwo = new Car("Saturn", "4Runner", 2009);
        Car carThree = new Car("Audi", "Q7", 2016);

        carOne.setMake("Honda");
        carTwo.setModel("Vue");
        carThree.setYear(2012);

        System.out.println(carOne);
        System.out.println("\n" + carTwo);
        System.out.println("\n" + carThree);
    }
}

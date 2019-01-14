package chapter4;

public class Kennel {

    public static void main(String args[]) {
        Dog jack = new Dog("Jack", 4);
        Dog cooper = new Dog("Cooper", 2);

        jack.setAge(jack.getAge()+1);
        cooper.setName(cooper.getName()+"Doo");

        System.out.println(jack);
        System.out.println(cooper);
        System.out.println("Jack Dog Years: " + jack.getDogYears());
        System.out.println("Cooper Dog Years: " + cooper.getDogYears());
    }

    /** OUTPUT
     * Dog Name: Jack, Dog Age: 5
     * Dog Name: CooperDoo, Dog Age: 2
     * Jack Dog Years: 35
     * Cooper Dog Years: 14
     *
     * Process finished with exit code 0
     */
}

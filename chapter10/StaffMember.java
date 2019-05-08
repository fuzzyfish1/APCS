package chapter10;

abstract public class StaffMember implements Payable {

    protected String name;
    protected String address;
    protected String phone;

    //-----------------------------------------------------------------
    // Constructor: Sets up this staff member using the specified
    // information.
    //-----------------------------------------------------------------
    public StaffMember (String eName, String eAddress, String ePhone) {
        name = eName;
        address = eAddress;
        phone = ePhone;
    }

    //-----------------------------------------------------------------
    // Returns a string including the basic employee information.
    //-----------------------------------------------------------------
    public String toString() {
        String result = "Name: " + name + "\n";
        result += "Address: " + address + "\n";
        result += "Phone: " + phone;
        return result;
    }
}
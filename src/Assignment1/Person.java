
package assignment1;

public class Person {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Person p = new Person("Brent", "Burbidge", "619.876.9097",
                "Brent.M.Burbidge@gmail.com");

        System.out.println("Person: First Name: " + p._firstName);
        System.out.println("Last Name: " + p._lastName);
        System.out.println("Phone Number: " + p._phoneNumber);
        System.out.println("Email Address: " + p._emailAddress);
        System.exit(0);

    }

    /** Declaring String Variables **/
    private String _firstName;
    private String _lastName;
    private String _phoneNumber;
    private String _emailAddress;

    public Person(String firstName, String lastName, String phoneNum,
            String email) {

        setemailAddress(email);
        setfirstName(firstName);
        setlastName(lastName);
        setphoneNumber(phoneNum);
    }

    public String getfirstName() {

        return _firstName;
    }

    public void setfirstName(String _firstName) {

        this._firstName = _firstName;
    }

    public String getlastName() {

        return _lastName;
    }

    public void setlastName(String _lastName) {

        this._lastName = _lastName;
    }

    public String getphoneNumber() {

        return _phoneNumber;
    }

    public void setphoneNumber(String _phoneNumber) {

        this._phoneNumber = _phoneNumber;
    }

    public String getemailAddress() {

        return _emailAddress;
    }

    public void setemailAddress(String _emailAddress) {

        this._emailAddress = _emailAddress;
    }

}


package Java2Assignment3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Cloneable {

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

    /** Declaring String Variables **/
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private Date birthDate;
    private Boolean hasBirthDay;

    public Person() {

    };

    public Person(String firstName, String lastName, String email,
            String phoneNum) {

        setEmailAddress(email);
        setfirstName(firstName);
        setlastName(lastName);
        setPhoneNumber(phoneNum);
        setHasBirthDay(false);
    }

    public Person(String firstName, String lastName, String email,
            String phoneNum, String dateOfBirth) {

        setEmailAddress(email);
        setfirstName(firstName);
        setlastName(lastName);
        setPhoneNumber(phoneNum);
        setHasBirthDay(true);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date t;
            t = sdf.parse(dateOfBirth);
            setBirthDate(t);
        }
        catch (ParseException pe) {

        }

    }

    @Override
    public String toString() {

        return this.firstName + "," + this.lastName + "," + this.emailAddress
                + "," + this.phoneNumber;
    }

    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj != null && getClass() == obj.getClass()) {
            Person p = (Person) obj;
            if (this.firstName.equalsIgnoreCase(p.firstName)
                    && this.lastName.equalsIgnoreCase(p.lastName)
                    && this.emailAddress.equalsIgnoreCase(p.emailAddress)
                    && this.phoneNumber.equals(p.phoneNumber))
                return true;
        }
        return false;
    }

    public int hashCode() {

        return this.emailAddress.toLowerCase().hashCode();
    }

    public int compareTo(Object o) {

        String s1 = this.lastName + this.firstName;
        String s2 = ((Person) o).lastName + ((Person) o).firstName;
        return s1.compareTo(s2);
    }

    protected Object clone() throws CloneNotSupportedException {

        Person clone = (Person) super.clone();

        return clone;

    }

    public String getfirstName() {

        return firstName;
    }

    public void setfirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getlastName() {

        return lastName;
    }

    public void setlastName(String lastName) {

        this.lastName = lastName;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {

        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {

        this.emailAddress = emailAddress;
    }

    public String getBirthDate() {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String reportDate = df.format(birthDate);
        return reportDate;
    }

    public void setBirthDate(Date birthDate) {

        this.birthDate = birthDate;
    }

    public Boolean getHasBirthDay() {

        return hasBirthDay;
    }

    public void setHasBirthDay(Boolean hasBirthDay) {

        this.hasBirthDay = hasBirthDay;
    }

}

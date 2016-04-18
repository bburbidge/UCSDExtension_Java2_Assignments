
package Java2Assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DayTimer implements Organizer, WhoDoneIt {

    private ArrayList<Person> people = new ArrayList<Person>();

    public DayTimer() {

    }

    public Person getAuthor() {

        Person P = new Person("Brent", "Burbidge", "619.876.9097",
                "Brent.M.Burbidge@gmail.com");

        return P;
    }

    public void add(Person p) {

        if (findByEmail(p.getEmailAddress()) == null) {
            this.people.add(p);
        } else {
            System.out.println("This email address already exists");
        }

    }

    public void remove(String email) {

        for (int n = 0; n < this.getSize(); n++) {
            if (this.people.get(n).getEmailAddress().equalsIgnoreCase(email)) {
                this.people.remove(n);
            }
        }

    }

    public void empty() {

        this.people.clear();

    }

    public Person[] find(String lastName) {

        Person[] l = new Person[0];
        for (int n = 0; n < this.getSize(); n++) {
            if (this.people.get(n).getlastName().equalsIgnoreCase(lastName)) {
                // l[l.length].equals(this.people[n]);
            }
        }
        return l;
    }

    public Person findByEmail(String email) {

        for (int n = 0; n < this.getSize(); n++) {
            if (!this.people.get(n).equals(null))
                if (this.people.get(n).getEmailAddress()
                        .equalsIgnoreCase(email)) {
                    return this.people.get(n);
                }
        }
        return null;
    }

    public Person[] getSortedListByLastName() {

        Collections.sort(this.people, COMPARE_BY_LAST_NAME);
        Person[] personArray = this.people.toArray(new Person[this.getSize()]);

        return personArray;
    }

    public Person[] getSortedListByFirstName() {

        Collections.sort(this.people, COMPARE_BY_FIRST_NAME);
        Person[] personArray = this.people.toArray(new Person[this.getSize()]);
        return personArray;
    }

    public int getSize() {

        return this.people.size();
    }

    private static Comparator<Person> COMPARE_BY_FIRST_NAME = new Comparator<Person>() {

        public int compare(Person one, Person other) {

            return one.getfirstName().compareTo(other.getfirstName());
        }
    };

    private static Comparator<Person> COMPARE_BY_LAST_NAME = new Comparator<Person>() {

        public int compare(Person one, Person other) {

            return one.getlastName().compareTo(other.getlastName());
        }
    };

    // private static void unitTestCode1() {
    //
    // DayTimer d = new DayTimer();
    // StringBuilder sb = new StringBuilder();
    // sb.append("Author: ");
    // sb.append(d.getAuthor().getfirstName());
    // sb.append(" ");
    // sb.append(d.getAuthor().getlastName());
    // sb.append(". email address: ");
    // sb.append(d.getAuthor().getEmailAddress());
    // System.out.println(sb);
    //
    // }
    //
    // private static void unitTestCode2() {
    //
    // unitTestCode1();
    // Person p1 = new Person("John", "Hamm", "555.555.5555", "MadMen@amc.com");
    // Person p2 = new Person("Jessica", "Parker", "333.333.3333",
    // "HorseFace@uggo.com");
    // Person p3 = new Person("Walter", "White", "333.333.3333",
    // "Heisenburg@bluepersuasion.com", "1963-04-23");
    // Person p4 = new Person("January", "Jones", "222.222.2222",
    // "MadMen@amc.com");
    //
    // DayTimer dt = new DayTimer();
    // dt.add(p3);
    // dt.add(p2);
    // dt.add(p1);
    // dt.add(p4);
    //
    // for (int n = 0; n < dt.getSize(); n++)
    // System.out.println(dt.people.get(n));
    //
    // dt.getSortedListByFirstName();
    //
    // for (int n = 0; n < dt.getSize(); n++)
    // System.out.println(dt.people.get(n));
    //
    // dt.getSortedListByLastName();
    //
    // for (int n = 0; n < dt.getSize(); n++)
    // System.out.println(dt.people.get(n));
    //
    // System.out.println(dt.findByEmail("Heisenburg@bluepersuasion.com")
    // .toString());
    //
    // dt.remove("HorseFace@uggo.com");
    //
    // for (int n = 0; n < dt.getSize(); n++)
    // System.out.println(dt.people.get(n));
    //
    // System.exit(0);
    //
    // }

    /**
     * @param args
     */
    // public static void main(String[] args) {
    //
    // unitTestCode2();
    // }

}

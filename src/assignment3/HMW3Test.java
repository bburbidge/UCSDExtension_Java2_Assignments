
package assignment3;

/**
 * Created by IntelliJ IDEA. User: Kent Yang UCSD Date: Apr 2, 2006 Time:
 * 3:37:54 PM email: kentyang@san.rr.com URL: www.javathehut.org
 */
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

public class HMW3Test extends TestCase {

    public static final Person SORTED[] = {
            new Person("aaa", "aaa", "aaa@aaa.com", "1111111"),
            new Person("bbb", "bbb", "bbb@bbb.com", "2222222"),
            new Person("ccc", "ccc", "ccc@ccc.com", "3333333"),
            new Person("ddd", "ddd", "ddd@ddd.com", "4444444"),
            new Person("yyy", "yyy", "yyy@yyy.com", "5555555"),
            new Person("zzz", "zzz", "zzz@zzz.com", "6666666"), };
    public static final Person SORTED_CCC[] = {
            new Person("ccc", "ccc", "ccc@ccc.com", "3333333"),
            new Person("ddd", "ccc", "ddd@ddd.com", "4444444"),
            new Person("yyy", "ccc", "yyy@yyy.com", "5555555"), };

    public void tearDown() {

        System.out.println("This was implemented by: "
                + ((WhoDoneIt) this.organizer).getAuthor());
    }

    public void setUp() {

        this.organizer = new DayTimer();
    }

    public void testBasic() {

        for (int i = SORTED.length; --i >= 0;) {
            this.organizer.add(SORTED[i]);
        }
        Person[] sortedList = this.organizer.getSortedListByFirstName();
        assertEquals("Incorrect number of items added",
                this.organizer.getSize(), SORTED.length);
        for (int i = 0; i < sortedList.length; i++) {
            assertEquals("Sort by First Name Test Failed!", SORTED[i],
                    sortedList[i]);
        }
        this.organizer.empty();
        // Testing empty and getSize
        assertEquals("Failed empty or getSize() test!",
                this.organizer.getSize(), 0);
        this.organizer.add(SORTED[1]);
        this.organizer.add(SORTED[0]);
        this.organizer.add(SORTED[3]);
        this.organizer.add(SORTED[2]);
        this.organizer.add(SORTED[5]);
        this.organizer.add(SORTED[4]);

        sortedList = this.organizer.getSortedListByLastName();
        assertEquals("Incorrect number of items added",
                this.organizer.getSize(), SORTED.length);
        for (int i = 0; i < sortedList.length; i++) {
            assertEquals("Sortby Last Name Test Failed!", SORTED[i],
                    sortedList[i]);
        }
        this.organizer.add(new Person("ccc", "ccc", "ccc@ccc.com", "3333333"));
        sortedList = this.organizer.getSortedListByLastName();
        for (int i = 0; i < sortedList.length; i++) {
            assertEquals("Failed duplicate test!", SORTED[i], sortedList[i]);
        }
        Person toRemove = organizer.findByEmail("zzz@zzz.com");
        assertNotNull("Failed findByEmail Test!", toRemove);
        if (toRemove != null) {
            this.organizer.remove("zzz@zzz.com");
            Person removed = organizer.findByEmail("zzz@zzz.com");
            assertNull("Failed remove Test!", removed);
            assertEquals("Failed remove or getSize() test!",
                    this.organizer.getSize(), SORTED.length - 1);
            sortedList = this.organizer.getSortedListByLastName();
            for (int i = 0; i < sortedList.length; i++) {
                assertEquals("Failed duplicate test!", SORTED[i], sortedList[i]);
            }
        }
        Person[] allCCC = organizer.find("ccc");
        for (int i = 0; i < allCCC.length; i++) {
            assertEquals("Failed find by last name test!", SORTED_CCC[i],
                    allCCC[i]);
        }
        this.organizer.add(new Person("ddd", "ccc", "ddd@ddd.com", "4444444"));
        this.organizer.add(new Person("yyy", "ccc", "yyy@yyy.com", "5555555"));
        allCCC = organizer.find("ccc");
        List l = new ArrayList();
        for (Person p : allCCC)
            l.add(p);
        for (Person p : allCCC)
            assertTrue("Failed find by last name test!", l.contains(p));
    }

    private Organizer organizer;
    private WhoDoneIt au;
}
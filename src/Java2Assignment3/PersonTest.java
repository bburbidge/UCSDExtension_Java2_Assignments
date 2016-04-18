
package Java2Assignment3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
// JDK 5.0 annotation support
// Using JDK 5.0 static imports
// Using JDK 5.0 static imports
// Need this to be compaitable with
                                          // old test driver

public class PersonTest {

    /**
     * A test to verify equals method.
     */
    @Test
    public void checkEquals() {

        Person p1 = new Person("Kent", "Yang", "kentyang@san.rr.com",
                "8588296201");
        assertTrue(p1.equals(p1)); // first check in equals method
        assertFalse(p1.equals(null)); // second check in equals method
        assertFalse(p1.equals(new Object())); // third check in equals method
        Person p2 = new Person("Kent", "Yang", "kentyang@san.rr.com",
                "8588296201");
        assertTrue(p1.equals(p2)); // Check for deep comparison
        p1 = new Person("Kent", "Yang", "kentyang@san.rr.com", "8588296201");
        p2 = new Person("David", "Yang", "davidyang@yahoo.com", "8588296201");
        assertFalse(p1.equals(p2)); // Check for deep comparison
    }
}
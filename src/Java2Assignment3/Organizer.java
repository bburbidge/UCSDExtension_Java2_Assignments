package Java2Assignment3;




/***************************************************************************
 * Organizer.java - This is the interface that you must provide with a concrete
 * implementation. It represents a in memory manager/organizer for Person
 * Objects.
 * 
 * @author Kent Yang
 ***************************************************************************/
public interface Organizer {

    /**
     * Add a Person to the organizer.
     * 
     * @param p
     *            A person object.
     */
    public void add(Person p);

    /**
     * Remove a Person from the organizer.
     * 
     * @param email
     *            The email of the person to be removed.
     */
    public void remove(String email);

    /**
     * Remove all contacts from the organizer.
     */
    public void empty();

    /**
     * Find all persons stored in the organizer with the same last name. Note,
     * there can be multiple persons with the same last name.
     * 
     * @param lastName
     *            The last name of the persons your are looking for.
     */
    public Person[] find(String lastName);

    /**
     * Find the person stored in the organizer with the email address. Note,
     * each person will have a unique email address.
     * 
     * @param email
     *            The person email address you are looking for.
     */
    public Person findByEmail(String email);

    /**
     * Return all the contact from the orgnizer in an array sorted by last name.
     * 
     * @return An array of Person objects.
     */
    public Person[] getSortedListByLastName();

    /**
     * Return all the contact from the orgnizer in an array sorted by first
     * name.
     * 
     * @return An array of Person objects.
     */
    public Person[] getSortedListByFirstName();

    /**
     * Return the current number of Person stored in the organizer.
     * 
     * @return An integer that indicate the number of Person object currently
     *         being stored.
     */
    public int getSize();
}

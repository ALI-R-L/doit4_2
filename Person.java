/**
 * store voter information : firstName and lastName
 * @author Ali Rezaei La'l
 * @version 1.0 2021
 */
public class Person {


    private String firstName ;
    private String lastName;

    /**
     * creates new object of Person class.
     * @param firstName
     * @param lastName
     */
    public Person(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * return firstName field of class
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * return lastName field of class
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * returns person information in a string
     * @return person Information
     */
    public String toString() {
        return "first name : "+firstName + " last name : "+lastName;
    }
}

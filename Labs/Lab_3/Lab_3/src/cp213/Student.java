package cp213;

import java.time.LocalDate;

/**
 * Student class definition.
 *
 * @author Name
 * @version 2023-10-02
 */
public class Student implements Comparable<Student> {

    // Attributes
    private LocalDate birthDate = null;
    private String forename = "";
    private int id = 0;
    private String surname = "";

    /**
     * Instantiates a Student object.
     *
     * @param id        student ID number
     * @param surname   student surname
     * @param forename  name of forename
     * @param birthDate birthDate in 'YYYY-MM-DD' format
     */
    public Student(int id, String surname, String forename, LocalDate birthDate) {

	this.birthDate = birthDate;
	this.forename = forename;
	this.id = id;
	this.surname = surname;

	return;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString() Creates a formatted string of student data.
     */
    @Override
    public String toString() {
	String string = "";

	string += "Name:       " + this.surname + ", " + this.forename + "\n";
	string += "ID:         " + this.id + "\n";
	string += "Birthdate:  " + this.birthDate;

	return string;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(final Student target) {

	int result = 0;

	// your code here
	// result = 0 - means s1 and s2 are the same
	// result <0 - means s1 comes before s1
	// result >0 - means s1 comes after s2

	// compare surname to target surname and get result from above
	result = this.surname.compareTo(target.surname);

	// if result is equal to 0 ( means surnames are the same)
	if (result == 0) {
	    // compare forename to target forename and get result from above
	    // since result is 0 add the new result to it
	    result += this.forename.compareTo(target.forename);
	    // if result is 0 for this as well
	    if (result == 0) {
		// compare the IDs
		result += Integer.compare(this.id, target.id);
	    }
	}
	return result;
    }

    // getters and setters defined here

    // getter
    public LocalDate getBirthDate() {
	return this.birthDate;
    }

    public String getForename() {
	return this.forename;
    }

    public int getId() {
	return this.id;
    }

    public String getSurname() {
	return this.surname;
    }

    // setter
    public void setBirthDate(LocalDate birthDate) {
	this.birthDate = birthDate;
    }

    public void setForename(String forename) {
	this.forename = forename;
    }

    public void setId(int id) {
	this.id = id;
    }

    public void setSurname(String surname) {
	this.surname = surname;
    }

}

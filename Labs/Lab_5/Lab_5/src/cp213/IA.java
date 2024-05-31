package cp213;

/**
 * Inherited class in simple example of inheritance / polymorphism.
 *
 * @author Name
 * @version 2023-10-26
 */
public class IA extends Student {

    private String course = null;

    /**
     * @param lastName  Professor last name
     * @param firstName Professor first name
     * @param id        Professor ID
     * @param course    Professor Course Taught
     */
    public IA(final String lastName, final String firstName, final String id, final String course) {
	super(lastName, firstName, course);
	this.course = course;
	this.id = id;

    }

    /**
     * Getter for Course
     * 
     * @return course
     */
    public String getCourse() {
	return this.course;

    }

    /**
     * String for returning course
     * 
     * @return course as a string
     */
    @Override
    public String toString() {
	return (super.toString() + "\n" + "Course: " + course);
    }

}
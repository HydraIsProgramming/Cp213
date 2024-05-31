package cp213;

/**
 * Inherited class in simple example of inheritance / polymorphism.
 *
 * @author Name
 * @version 2023-10-26
 */
public class CAS extends Professor {

    protected String term = null;

    /**
     * @param lastName   Professor last name
     * @param firstName  Professor first name
     * @param department Professor department
     * @param term       Professor term of teaching subject
     */
    public CAS(final String lastName, final String firstName, final String department, final String term) {
	super(lastName, firstName, department);
	this.term = term;
    }

    /**
     * Getter for Term
     * 
     * @return term
     */
    public String getTerm() {
	return this.term;
    }

    /**
     * String for returning term
     * 
     * @return term as a string
     */
    @Override
    public String toString() {
	return (super.toString() + "\n" + "Term: " + this.term);
    }
}

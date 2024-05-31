package cp213;

import java.io.PrintStream;

/**
 * Food class definition.
 *
  * @author Name
 * @version 2023-10-14
 */
public class Food implements Comparable<Food> {

    // Constants
    public static final String ORIGINS[] = { "Canadian", "Chinese", "Indian", "Ethiopian", "Mexican", "Greek",
	    "Japanese", "Italian", "Moroccan", "Scottish", "Columbian", "English" };

    /**
     * Creates a string of food origins in the format:
     *
     * <pre>
    Origins
    0 Canadian
    1 Chinese
    ...
    11 English
     * </pre>
     *
     * @return A formatted numbered string of valid food origins.
     */
    public static String originsMenu() {

	String food_types = "";

	for (int i = 0; i < ORIGINS.length; i++) {
	    food_types += "\n" + i + " " + ORIGINS[i];
	}

	return food_types;
    }

    // Attributes
    private String name = null;
    private int origin = 0;
    private boolean isVegetarian = false;
    private int calories = 0;

    /**
     * Food constructor.
     *
     * @param name         food name
     * @param origin       food origin code
     * @param isVegetarian whether food is vegetarian
     * @param calories     caloric content of food
     */
    public Food(final String name, final int origin, final boolean isVegetarian, final int calories) {

	this.name = name;
	this.origin = origin;
	this.isVegetarian = isVegetarian;
	this.calories = calories;

	return;
    }

    /*
     * (non-Javadoc) Compares this food against another food.
     *
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    /**
     * Foods are compared by name, then by origin if the names match. Must ignore
     * case.
     */
    @Override
    public int compareTo(final Food target) {

	int return_this = 0;

	if (target.name.equals(this.name)) {

	    if (target.origin > this.origin) {
		return_this = -1;
	    } else if (target.origin < this.origin) {
		return_this = 1;
	    } else {
		return_this = 0;
	    }

	} else {
	    return_this = this.name.compareTo(target.name);
	}

	return return_this;
    }

    /**
     * Getter for calories attribute.
     *
     * @return calories
     */
    public int getCalories() {

	return calories;
    }

    /**
     * Getter for name attribute.
     *
     * @return name
     */
    public String getName() {

	return name;
    }

    /**
     * Getter for origin attribute.
     *
     * @return origin
     */
    public int getOrigin() {

	return origin;
    }

    /**
     * Getter for string version of origin attribute.
     *
     * @return string version of origin
     */
    public String getOriginString() {

	String string_ORIGIN = ORIGINS[origin];

	return string_ORIGIN;

    }

    /**
     * Getter for isVegetarian attribute.
     *
     * @return isVegetarian
     */
    public boolean isVegetarian() {

	return this.isVegetarian;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object//toString() Creates a formatted string of food data.
     */
    /**
     * Returns a string version of a Food object in the form:
     *
     * <pre>
    Name:       name
    Origin:     origin string
    Vegetarian: true/false
    Calories:   calories
     * </pre>
     */
    @Override
    public String toString() {

	String output = "";

	output += String.format("\n%-12s %s" + "\n%-12s %d" + "\n%-12s %b" + "\n%-12s %d", "Name:", name, "Origin:",
		origin, "Vegetarian:", isVegetarian, "Calories:", calories);

	return output;
    }

    /**
     * Writes a single line of food data to an open PrintStream. The contents of
     * food are written as a string in the format name|origin|isVegetarian|calories
     * to ps.
     *
     * @param ps The PrintStream to write to.
     */
    public void write(final PrintStream ps) {

	ps.append(name + "|" + origin + "|" + isVegetarian + "|" + calories);

	return;
    }
}

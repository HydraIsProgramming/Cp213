package cp213;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Utilities for working with Food objects.
 *
 * @author Name
 * @version 2023-10-14
 */
public class FoodUtilities {

    /**
     * Determines the average calories in a list of foods. No rounding necessary.
     * Foods list parameter may be empty.
     *
     * @param foods a list of Food
     * @return average calories in all Food objects
     */
    public static int averageCalories(final ArrayList<Food> foods) {

	int calories = 0;
	for (int i = 0; i < foods.size(); i++) {

	    calories += foods.get(i).getCalories();

	}

	return calories / foods.size();
    }

    /**
     * Determines the average calories in a list of foods for a particular origin.
     * No rounding necessary. Foods list parameter may be empty.
     *
     * @param foods  a list of Food
     * @param origin the origin of the Food
     * @return average calories for all Foods of the specified origin
     */
    public static int averageCaloriesByOrigin(final ArrayList<Food> foods, final int origin) {

	ArrayList<Food> arrOrigin = new ArrayList();

	for (int i = 0; i < foods.size(); i++) {
	    if (foods.get(i).getOrigin() == origin) {
		arrOrigin.add(foods.get(i));
	    }
	}

	int calories = 0;
	for (int i = 0; i < arrOrigin.size(); i++) {
	    calories += arrOrigin.get(i).getCalories();
	}

	return calories / arrOrigin.size();
    }

    /**
     * Creates a list of foods by origin.
     *
     * @param foods  a list of Food
     * @param origin a food origin
     * @return a list of Food from origin
     */
    public static ArrayList<Food> getByOrigin(final ArrayList<Food> foods, final int origin) {

	ArrayList<Food> byOrigin = new ArrayList();

	for (int i = 0; i < foods.size(); i++) {
	    if (foods.get(i).getOrigin() == origin) {
		byOrigin.add(foods.get(i));
	    }
	}

	return byOrigin;
    }

    /**
     * Creates a Food object by requesting data from a user. Uses the format:
     *
     * <pre>
    Name: name
    Origins
     0 Canadian
     1 Chinese
    ...
    11 English
    Origin: origin number
    Vegetarian (Y/N): Y/N
    Calories: calories
     * </pre>
     *
     * @param keyboard a keyboard Scanner
     * @return a Food object
     */
    public static Food getFood(final Scanner keyboard) {

	System.out.println("Name: ");
	String name = keyboard.nextLine();
	System.out.println("");
	System.out.println("Origin: ");
	System.out.println(Food.originsMenu());
	int origin = keyboard.nextInt();

	System.out.println("Vegetarian? (Y/N): ");
	String vegetarian = keyboard.next();

	boolean isVegetarian;
	if (vegetarian == "Y" || vegetarian == "y") {
	    isVegetarian = true;
	} else {
	    isVegetarian = false;
	}

	System.out.println("Calories: ");
	int calories = keyboard.nextInt();

	Food item = new Food(name, origin, isVegetarian, calories);

	return item;
    }

    /**
     * Creates a list of vegetarian foods.
     *
     * @param foods a list of Food
     * @return a list of vegetarian Food
     */
    public static ArrayList<Food> getVegetarian(final ArrayList<Food> foods) {

	ArrayList<Food> arrVegetarian = new ArrayList();

	for (int i = 0; i < foods.size(); i++) {

	    if (foods.get(i).isVegetarian() == true) {
		arrVegetarian.add(foods.get(i));
	    }
	}

	return arrVegetarian;
    }

    /**
     * Creates and returns a Food object from a line of string data.
     *
     * @param line a vertical bar-delimited line of food data in the format
     *             name|origin|isVegetarian|calories
     * @return the data from line as a Food object
     */
    public static Food readFood(final String line) {

	String n;
	int o;
	boolean v;
	int c;

	String[] split = line.split("\\|");

	n = split[0];
	o = Integer.parseInt(split[1]);
	v = Boolean.parseBoolean(split[2]);
	c = Integer.parseInt(split[3]);

	Food item = new Food(n, o, v, c);

	return item;
    }

    /**
     * Reads a file of food strings into a list of Food objects.
     *
     * @param fileIn a Scanner of a Food data file in the format
     *               name|origin|isVegetarian|calories
     * @return a list of Food
     */
    public static ArrayList<Food> readFoods(final Scanner fileIn) {

	String n;
	int o;
	boolean v;
	int c;

	ArrayList<Food> arrfoodlist = new ArrayList<Food>();

	while (fileIn.hasNextLine()) {

	    String line = fileIn.nextLine();
	    String[] split = line.split("\\|");

	    n = split[0];
	    o = Integer.parseInt(split[1]);
	    v = Boolean.parseBoolean(split[2]);
	    c = Integer.parseInt(split[3]);

	    Food item = new Food(n, o, v, c);
	    arrfoodlist.add(item);

	}

	return arrfoodlist;
    }

    /**
     * Searches for foods that fit certain conditions.
     *
     * @param foods        a list of Food
     * @param origin       the origin of the food; if -1, accept any origin
     * @param maxCalories  the maximum calories for the food; if 0, accept any
     * @param isVegetarian whether the food is vegetarian or not; if false accept
     *                     any
     * @return a list of foods that fit the conditions specified
     */
    public static ArrayList<Food> foodSearch(final ArrayList<Food> foods, final int origin, final int maxCalories,
	    final boolean isVegetarian) {

	ArrayList<Food> matches = foods;

	if (origin != -1) {
	    matches = getByOrigin(foods, origin);
	}

	for (int i = 0; i < matches.size(); i++) {

	    if (maxCalories == 0) {
		break;
	    }

	    if (matches.get(i).getCalories() > maxCalories) {
		matches.remove(i);
	    }

	}

	for (int i = 0; i < matches.size(); i++) {

	    if (matches.get(i).isVegetarian() != isVegetarian) {
		matches.remove(i);
	    }
	}

	return matches;
    }

    /**
     * Writes the contents of a list of Food to a PrintStream.
     *
     * @param foods a list of Food
     * @param ps    the PrintStream to write to
     */
    public static void writeFoods(final ArrayList<Food> foods, PrintStream ps) {

	for (final Food food : foods) {
	    food.write(ps);
	}
    }

}

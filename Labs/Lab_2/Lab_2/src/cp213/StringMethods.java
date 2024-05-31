package cp213;

/**
 * Sample string methods.
 *
 * @author Name
 * @version 2023-09-26
 */
public class StringMethods {
    // Constants
    /**
     * String of vowels.
     */
    public static final String VOWELS = "aeiouAEIOU";

    /**
     * Counts the number of vowels in a string. Does not include 'y'.
     *
     * @param string A string.
     * @return Number of vowels in string.
     */
    public static int vowelCount(final String string) {

	// takes the string length
	int a = string.length();

	// Initializes count to 0
	int count = 0;

	// starts for loop
	// i=0 because initalization in the for loop
	// i<a because we want the for loop to run the same characters as string length
	// i++ increments the count by 1 each time
	for (int i = 0; i < a; i++) {

	    // set variable z
	    char z = string.charAt(i);
	    String vowel = Character.toString(z);

	    if (VOWELS.contains(vowel)) {
		count++;

	    }

	}

	return count;
    }

    /**
     * Counts the number of digits in a string.
     *
     * @param string A string.
     * @return Number of digits in string.
     */
    public static int digitCount(final String string) {
	int length = string.length();
	int count = 0;
	for (int i = 0; i < length; i++) {
	    char dig = string.charAt(i);
	    if (Character.isDigit(dig)) {
		int num = Character.getNumericValue(dig);
		count++;

	    }

	}

	return count;
    }

    /**
     * Totals the individual digits in a string.
     *
     * @param string A string.
     * @return The integer total of all individuals digits in string.
     */
    public static int totalDigits(final String string) {

	int length = string.length();
	int total = 0;
	for (int i = 0; i < length; i++) {
	    char dig = string.charAt(i);
	    if (Character.isDigit(dig)) {
		int num = Character.getNumericValue(dig);
		total += num;

	    }

	}

	return total;
    }

    /**
     * Compares string1 and string2 and returns a comma-delimited concatenated
     * string consisting of the string that is first lexically followed by the
     * string that is second lexically. If the strings are equal, then only string1
     * is returned.
     *
     * @param string1 String to compare against string2.
     * @param string2 String to compare against string1.
     * @return A concatenation of string1 and string2 in order.
     */
    public static String pairs(String string1, String string2) {
	String line = null;

	int compare = string1.compareTo(string2);

	if (compare > 0) {
	    line = string2 + "," + string1;

	} else if (compare < 0) {
	    line = string1 + "," + string2;

	} else {
	    line = string1;
	}

	return line;
    }

    /**
     * Finds the distance between the s1 and s2. The distance between two strings of
     * the same length is the number of positions in the strings at which their
     * characters are different. If two strings are not the same length, the
     * distance is unknown (-1). If the distance is zero, then two strings are
     * equal.
     *
     * @param string1 String to compare against string2.
     * @param string2 String to compare against string1.
     * @return The distance between string1 and string2.
     */
    public static int stringDistance(String string1, String string2) {
	int distance = 0;

	int length1 = string1.length();
	int length2 = string2.length();

	if (length1 != length2) {
	    distance = -1;
	} else {

	    for (int i = 0; i < length1; i++) {
		char letter1 = string1.charAt(i);
		char letter2 = string2.charAt(i);
		if (letter1 != letter2) {
		    distance++;
		}
	    }
	}

	return distance;
    }
}

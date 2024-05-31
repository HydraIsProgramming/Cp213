package cp213;

/**
 * @author Name
 * @version 2023-09-17
 */
public class Strings {
    // Constants
    public static final String VOWELS = "aeiouAEIOU";

    /**
     * Determines if string is a "palindrome": a word, verse, or sentence (such as
     * "Able was I ere I saw Elba") that reads the same backward or forward. Ignores
     * case, spaces, digits, and punctuation in the string parameter s.
     *
     * @param string a string
     * @return true if string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(final String string) {

	boolean palindrome = false;
	char[] sNorm = string.toCharArray();

	String normal = "";
	String reversed = "";

	for (int i = 0; i < string.length(); i++) {

	    if (Character.isAlphabetic(sNorm[i])) {
		normal += sNorm[i];
	    }
	}

	sNorm = normal.toCharArray();

	for (int i = sNorm.length - 1; i >= 0; i--) {

	    if (Character.isAlphabetic(sNorm[i])) {
		reversed += sNorm[i];
	    }
	}

	if (reversed.equalsIgnoreCase(normal)) {
	    palindrome = true;
	}

	return palindrome;
    }

    /**
     * Determines if name is a valid Java variable name. Variables names must start
     * with a letter or an underscore, but cannot be an underscore alone. The rest
     * of the variable name may consist of letters, numbers and underscores.
     *
     * @param name a string to test as a Java variable name
     * @return true if name is a valid Java variable name, false otherwise
     */

    public static boolean isValid(final String name) {

	boolean flutter = true;
	String figma = "1234567890";
	String wix = "_";

	if (figma.contains(name.substring(0, 1))) {
	    flutter = false;
	}

	if (wix.contains(name.substring(0, 1))) {
	    if (name.length() == 1) {
		flutter = false;
	    }
	}

	return flutter;
    }

    /**
     * Converts a word to Pig Latin. The conversion is:
     * <ul>
     * <li>if a word begins with a vowel, add "way" to the end of the word.</li>
     * <li>if the word begins with consonants, move the leading consonants to the
     * end of the word and add "ay" to the end of that. "y" is treated as a
     * consonant if it is the first character in the word, and as a vowel for
     * anywhere else in the word.</li>
     * </ul>
     * Preserve the case of the word - i.e. if the first character of word is
     * upper-case, then the new first character should also be upper case.
     *
     * @param word The string to convert to Pig Latin
     * @return the Pig Latin version of word
     */
    public static String pigLatin(String word) {

	boolean yes = false;
	if (Character.isUpperCase(word.charAt(0))) {
	    word.toLowerCase();
	    yes = true;
	}

	if (VOWELS.contains(word.substring(0, 1))) {
	    word += "way";
	} else {
	    // append all leading consonants to end
	    // remove all leading consonants

	    for (int i = 0; i < word.length(); i++) {
		char c = word.charAt(i);
		int j = word.indexOf(c);

		if (j == 0) {
		    word += c;
		    word = word.substring(1, word.length());
		}

	    }

	    word += "ay";

	}
	word = word.toLowerCase();
	if (yes) {
	    word = word.substring(0, 1).toUpperCase() + word.substring(1);

	}

	return word;
    }

}
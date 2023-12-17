package cp213;

import java.util.Scanner;

/**
 * Class to demonstrate the use of Scanner with a keyboard and File objects.
 *
 * @author Ranjot Sandhu 169020301
 * @version 2023-09-16
 */
public class ScannerTest {

    /**
     * Count lines in the scanned file.
     *
     * @param source Scanner to process
     * @return number of lines in scanned file
     */
    public static int countLines(final Scanner source) {
	int count = 0;

	while (source.hasNextLine()) {
	    count += 1;
	    source.nextLine();
	}

	return count;
    }

    /**
     * Count tokens in the scanned object.
     *
     * @param source Scanner to process
     * @return number of tokens in scanned object
     */
    public static int countTokens(final Scanner source) {
	int tokens = 0;

	while (source.hasNext()) {
	    tokens += 1;
	    source.next();
	}

	return tokens;
    }

    /**
     * Ask for and total integers from the keyboard.
     *
     * @param source Scanner to process
     * @return total of positive integers entered from keyboard
     */
    public static int readNumbers(final Scanner keyboard) {
	int total = 0;

	while (!keyboard.hasNext("q")) {

	    if (keyboard.hasNextInt()) {

		total += keyboard.nextInt();
	    }

	    else {

		System.out.println("'" + keyboard.next() + "' is not an integer or 'q'. ");
	    }

	}

	return total;
    }

}
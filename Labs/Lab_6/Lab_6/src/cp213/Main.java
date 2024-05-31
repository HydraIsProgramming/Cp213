package cp213;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /**
     * @param args unused
     */
    public static void main(String[] args) {
	System.out.println("Test scannerTest");
	System.out.println();
	Scanner keyboard = new Scanner(System.in);
	int total = scannerTest(keyboard);
	keyboard.close();
	System.out.println("Total: " + total);
	System.out.println();

	System.out.print("Test stringPrinter");
	System.out.println();

	try {
	    String output = stringPrinter(5, "*");
	    System.out.println(output);
	    output = stringPrinter(-5, "*");
	    System.out.println(output);
	} catch (Exception e) {
	    System.out.println();
	    System.out.println("getMessage:");
	    System.out.println(e.getMessage());
	    System.out.println();
	    System.out.println("toString:");
	    System.out.println(e.toString());
	    System.out.println();
	    System.out.println("printStackTrace:");
	    e.printStackTrace();
	}
    }

    /**
     * Uses exceptions to capture bad input from a keyboard Scanner.
     *
     * @param keyboard - Keyboard input into the console
     * @return The total of all the integers entered.
     */
    public static int scannerTest(final Scanner keyboard) {

	int total = 0;

	Boolean state = true;

	while (state == true) {

	    try {
		System.out.print("Enter an integer ('Quit' to stop): ");

		if (keyboard.hasNextInt()) {
		    int num = keyboard.nextInt();
		    total += num;

		} else {
		    String input_str = keyboard.next();
		    if (input_str.equals("Quit")) {
			break;
		    } else {
			throw new InputMismatchException();
		    }
		}

	    } catch (InputMismatchException e) {
		// generic exception/error catching
		System.err.println("That is not an Integer!");
		continue;

	    }

	}

	return total;
    }

    /**
     * Repeats a string.
     *
     * @param n   Number of times to repeat a string.
     * @param str The string to print.
     * @return The repeated string.
     * @throws Exception If n is negative.
     */
    public static String stringPrinter(int n, String str) throws Exception {

	String output_str = "";

	if (n > 0) {

	    for (int i = 0; i < n; i++) {
		output_str += str;
	    }

	} else {
	    throw new IllegalArgumentException(
		    "Please Enter a Positive Number! Not a negative Number!" + "(" + n + ")");
	}

	return output_str;
    }

}
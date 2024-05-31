package cp213;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Name
 * @version 2023-09-17
 */
public class SerialNumber {

    /**
     * Determines if a string contains all digits.
     *
     * @param str The string to test.
     * @return true if str is all digits, false otherwise.
     */
    public static boolean allDigits(final String str) {

	boolean digits = true;
	for (int i = 0; i < str.length(); i++)

	{
	    char c = str.charAt(i);

	    if (!Character.isDigit(c)) {
		digits = false;

	    }

	}

	return digits;
    }

    /**
     * Determines if a string is a good serial number. Good serial numbers are of
     * the form 'SN/nnnn-nnn', where 'n' is a digit.
     *
     * @param sn The serial number to test.
     * @return true if the serial number is valid in form, false otherwise.
     */
    public static boolean validSn(final String sn) {

	boolean form;
	if (sn.matches("SN/[0-9]{4}-[0-9]{3}")) {
	    form = true;
	} else {
	    form = false;
	}
	return form;
    }

    /**
     * Evaluates serial numbers from a file. Writes valid serial numbers to
     * good_sns, and invalid serial numbers to bad_sns.
     *
     * @param fileIn  a file already open for reading
     * @param goodSns a file already open for writing
     * @param badSns  a file already open for writing
     */
    public static void validSnFile(final Scanner fileIn, final PrintStream goodSns, final PrintStream badSns) {

	while (fileIn.hasNextLine()) {
	    String line = fileIn.nextLine();
	    if (validSn(line.trim())) {
		goodSns.println(line.trim());
	    } else {
		badSns.println(line.trim());
	    }
	}

	return;
    }
}

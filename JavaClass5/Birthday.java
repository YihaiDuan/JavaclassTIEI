//
// Introduction to Computer Programming with Java
// TIEI - August 2018
//
package assignment5;

import java.util.Scanner;

/**
 * A Birthday class for homework #5
 */
public class Birthday {

	/**
	 * The main function
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("How many days before your birthday???\n");
		do {
			SimpleDate today = getDate(input,"today's date");
			SimpleDate birthday = getDate(input,"your birthday");
			System.out.println( "There are " + birthday.daysInMonth() + " days in month #" + birthday.getMonth() );
			int numberOfDays = numberOfDays(today,birthday);
			if ( numberOfDays == 0 )
				System.out.println( "Happy birthday!\n" );
			else
				System.out.println( "Number of days until birthday " + birthday + ": " + numberOfDays + "\n\n");
		} while ( more(input) );
	}

	// compute and return the number of days
	// between the two SimpleDate from and to
	private static int numberOfDays(SimpleDate from, SimpleDate to) {
        int count = 0;
        SimpleDate newFrom = new SimpleDate(from);
		while (!newFrom.equals(to)) {
			count++;
			newFrom.nextDay();
		}
        return count;
	}

	// prompt the user with a suitable message, read a month
	// and a day, and return the corresponding SimpleDate object
	private static SimpleDate getDate(Scanner input, String prompt) {
		System.out.print("What is " + prompt + " (month and day)? ");
		return new SimpleDate(input.nextInt(),input.nextInt());
	}

	// prompt the user and read the answer
	private static boolean more(Scanner input) {
		while ( true ) {
			System.out.print("More? ");
			String answer = input.next().trim().toLowerCase();
			if ( answer.equals("yes") )
				return true;
			else if ( answer.equals("no") )
				return false;
			else
				System.out.print("(Please enter 'yes' or 'no') ");
		}
	}
}

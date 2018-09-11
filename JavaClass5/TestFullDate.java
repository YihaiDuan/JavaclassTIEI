//
// Introduction to Computer Programming with Java
// TIEI - August 2018
//
package assignment5;

import java.util.Scanner;

public class TestFullDate {

	/**
	 * The main function
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Day counter\n");
		do {
			FullDate date1 = getDate(input,"Enter first date (y m d): ");
			FullDate date2 = getDate(input,"Enter second date (y m d): ");
			if ( ! date1.lessOrEqual(date2) ) {
				FullDate tmp = date1;
				date1 = date2;
				date2 = tmp;
			}
			System.out.println("There are " + numberOfDays(date1, date2) + " days between " + date1 + " " + date2 + "\n");
		} while ( more(input) );
	}		

	// compute and return the number of days
	// between the two FullDate from and to
	private static int numberOfDays(FullDate from, FullDate to) {
		FullDate newFrom = new FullDate(from);
		if (newFrom.equals(to))
        	return 0;
        int count = 0;
        while(!newFrom.equals(to)) {
        	count++;
        	newFrom.nextDay();
        }
        return count;
	}

	// prompt the user with a suitable message, read a month
	// and a day, and return the corresponding FullDate object
	private static FullDate getDate(Scanner input, String prompt) {
		System.out.print(prompt);
		return new FullDate(input.nextInt(),input.nextInt(),input.nextInt());
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

//
// Introduction to Computer Programming with Java
// TIEI - August 2018
// Author: YihaiDuan
// Student ID: 2018229033
//
package assignment2;
import java.util.Random;

import java.util.Scanner;

/**
 * A class for assignment #2
 */
public class Guess {

	// The number to guess will be taken is the range [1,MAX]
	// You should use MAX any time you need to use '100' so
	// it's possibele to change 100 by another value without
	// changing the code below
	private static final int MAX = 10;
	static int minGuess= Integer.MAX_VALUE;
	static int totalGuess = 0;
	/**
	 * The main program
	 * (complete it)
	 */
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int timesOfGame = 0;
		
		do {
			int timeOfGuess = playOneGame(MAX,console);
			timesOfGame++;
			overall(timeOfGuess);			
		}while(interact(console));
		
		printResult(timesOfGame);
		//console.close();

	}
	//a method that introduces the game and interacts with the user
	public static boolean interact(Scanner console) {
		String ans;
		do{
			System.out.println("Do you want to play again?");
			ans = console.next();
		}while(!(ans.equals("yes") || ans.equals("no")));
		return ans.equals("yes");
	}
	//calculate minGuess and totalGuess
	public static void overall(int timeOfGuess) {
		if (timeOfGuess<minGuess)
			minGuess = timeOfGuess;
		totalGuess += timeOfGuess;		
	}
	//print the results
	public static void printResult(int timeOfGame) {
		System.out.println("Overall results:");
		System.out.println("  total games = " + timeOfGame);
		System.out.println("  total guuesses = " + totalGuess);
		System.out.println("  guesses/game = " + (double)totalGuess/timeOfGame);
		System.out.println("  best game = " + minGuess);
	}
	//Play one game
	public static int playOneGame(int maxNum,Scanner consoleInt) {
		System.out.println("I'm thinking of a number between 1 and " + maxNum + "...");
		Random rand = new Random();
		int thought = rand.nextInt(maxNum)+1;
		int ans;
		int count = 0;
		do {
			count++;
			System.out.print("Your guess? ");
			ans = consoleInt.nextInt();
			if (ans > thought)
				System.out.println("It's lower.");
			else if(ans < thought)
				System.out.println("It's higher.");
		}while(ans != thought);

		System.out.println("You got it right in "+count + " guesses");
		return count;
	}

}

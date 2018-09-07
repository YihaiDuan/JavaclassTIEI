//
// Introduction to Computer Programming with Java
// TIEI - August 2018
// Author: YihaiDuan
// ID: 2018229033
package assignment1;

import java.util.*;

/**
 * A class for assignment #1
 */
public class DrawRocket {

	/**
	 * The main program
	 * (don't change it)
	 */
	public static void main(String[] args) {
		int n = readInt();
		while ( n > 0 ) {
			drawRocket(n);
			System.out.println();
			n = readInt();
		}
	}
	
	/**
	 * Simple utility function to read
	 * an integer from the user
	 * (don't change it)
	 */
	private static int readInt() {
		Scanner console = new Scanner(System.in);
		int n = 0;
		do {
			System.out.print("Enter the size (0 to exit);: ");
			n = console.nextInt();
		} while ( n < 0 );
		return n;
	}
	
	/**
	 * The function which draws the rocket of size 'size'
	 * (Complete it)
	 */
	private static void drawRocket(int size) {
		drawHeadAndTail(size);
		drawLineCenter(size);
		
		drawUpHalf(size);
		drawDownHalf(size);
		
		drawLineCenter(size);
		
		drawDownHalf(size);
		drawUpHalf(size);
		
		drawLineCenter(size);
		drawHeadAndTail(size);

	}

    // draw repeat strings.
	private static void drawRepeatChars(int size, String s){
		for (int i=0; i<size; i++){
			System.out.print(s);
		}
	}
	
	//draw +=*=*=*=*=*=*+
	private static void drawLineCenter(int size){
		System.out.print("+");
		drawRepeatChars(size*2,"=*");
		System.out.println("+");
	}
	// draw head and tail
	private static void drawHeadAndTail(int size){
		int lineTotal = size*2-1;
		for(int i = 1; i<=lineTotal; i++){
			drawRepeatChars(lineTotal+1-i," ");
			drawRepeatChars(i,"/");
			System.out.print("**");
			drawRepeatChars(i,"\\");
			System.out.println();
		}
	}
	//draw the top half part
	private static void drawUpHalf(int size){
		
		for(int i=1; i<=size; i++){
			System.out.print("|");
			drawRepeatChars(size-i,".");
			drawRepeatChars(i,"/\\");
			drawRepeatChars((size-i)*2,".");
			drawRepeatChars(i,"/\\");
			drawRepeatChars(size-i,".");
			System.out.println("|");
		}
		
	}
	//draw the bottom half part
	private static void drawDownHalf(int size){
		for(int i=1; i<=size; i++){
			System.out.print("|");
			drawRepeatChars(i-1,".");
			drawRepeatChars(size+1-i,"\\/");
			drawRepeatChars((i-1)*2,".");
			drawRepeatChars(size+1-i,"\\/");
			drawRepeatChars(i-1,".");
			System.out.println("|");
		}
	}
	
}

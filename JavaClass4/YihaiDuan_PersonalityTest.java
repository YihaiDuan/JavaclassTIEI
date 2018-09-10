//
// Introduction to Computer Programming with Java
// TIEI - August 2018
// Author: YihaiDuan
// ID: 2018229033
//
package assignment4;
import java.util.*;
import java.io.*;
public class PersonalityTest {
	public static final int NUM_ANS = 70;
	public static final int JUDGE_LINE = 50;
	public static final String INPUT_FILENAME = "bigdata.txt";
	public static final String OUTPUT_FILENAME = INPUT_FILENAME.replaceAll(".txt", "-output.txt");
	public static final String[] ANS = {"EI","SN","TF","JP"}; 

	public static void main(String[] args) throws FileNotFoundException {		
		File file = new File(INPUT_FILENAME);
		Scanner input = new Scanner(file);
		PrintStream output = new PrintStream(new File(OUTPUT_FILENAME));
		
		while(input.hasNextLine()) {		
			String name = input.nextLine();
			String ABs = input.nextLine();
			
			String result = countResult(name,ABs);
			
			writeResult(output,result);			
		}
		input.close();
	}
	//get the result personality
	public static String countResult(String name, String ABs) {
		int [] count_A = {0,0,0,0};
		int [] count_B = {0,0,0,0};
		//use the two functions to count As, Bs and the percentage of B.
		countsOfAandB(ABs,count_A,count_B);
		int []percentArray = percentage(count_A,count_B);
		
		String result= "";
		for(int i=0; i<percentArray.length; i++) {
			if (percentArray[i]<JUDGE_LINE)
				result += ANS[i].charAt(0);
			else if (percentArray[i]>JUDGE_LINE)
				result += ANS[i].charAt(1);
			else
				result += 'X';
		}
		result = name + ": " + Arrays.toString(percentArray) + " = " + result;
		return result;
	}
	// count As and Bs.
	public static void countsOfAandB(String ABs,int [] count_A,int []count_B) {			
		ABs = ABs.toLowerCase();
		for(int i=0; i<NUM_ANS; i++) {
			if (i%7==0) {
				if (ABs.charAt(i)=='a')
					count_A[0]++;
				else if(ABs.charAt(i)=='b')
					count_B[0]++;
			}
			if (i%7==1 || i%7==2) {
				if (ABs.charAt(i)=='a')
					count_A[1]++;
				else if(ABs.charAt(i)=='b')
					count_B[1]++;
			}
			if (i%7==3 || i%7==4) {
				if (ABs.charAt(i)=='a')
					count_A[2]++;
				else if(ABs.charAt(i)=='b')
					count_B[2]++;
			}
			if (i%7==5 || i%7==6) {
				if (ABs.charAt(i)=='a')
					count_A[3]++;
				else if(ABs.charAt(i)=='b')
					count_B[3]++;
			}
		}
	}
	//Calculate B's percentage.
	public static int [] percentage(int [] count_A,int []count_B) {
		int []percentArray = new int[4];
		double percent;
		
		for(int i=0; i<count_A.length;i++) {
			if(count_A[i]+count_B[i] == 0)
				percent = 0.0;
			else 
				percent = (double)count_B[i]/(count_A[i]+count_B[i])*100;
			percentArray[i] = (int)Math.round(percent);
		}
		return percentArray;
	}

	//Write the results to the output file.
	public static void writeResult(PrintStream output,String result) {
		output.println(result);
	}

}

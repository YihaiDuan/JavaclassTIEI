package assignment6;
import java.util.*;
public class CheckBalance {
	private char []array = {'{','}','[',']','(',')','<','>'};
	private String input;
	//Stack <Character> st = new Stack<Character>();
	//ArrayStack st = new ArrayStack();
	ListStack<Character> st = new ListStack<Character>();
	public CheckBalance(String s) {
		this.input = s;
	}
	public boolean balanced() {
		for(int i=0; i<input.length(); i++) {
			if (isInArray(input.charAt(i))) {
				if(!st.isEmpty()) {
					char anotherHalf = getAnotherHalf(st.peek());
					if (anotherHalf == ' ')
						return false;
					if(anotherHalf == input.charAt(i))
						st.pop();
					else 
						st.push(input.charAt(i));
				}
				else 
					st.push(input.charAt(i));
			}
		}
		return st.isEmpty();
	}
	public boolean isInArray(char c) {
		
		for (int i=0; i<array.length; i++) {
			if (c == array[i])
				return true;
		}
		return false;
	}
	public char getAnotherHalf(char c) {
		for(int i=0; i<array.length; i+=2) {
			if (c == array[i])
				return array[i+1];
		}
		return ' ';
	}
	public int index() {
		char remain = st.pop();
		char getAnotherHalf = getAnotherHalf(remain);
		if (getAnotherHalf != ' ')
			return input.length();
		for(int i=0; i<input.length();i++) {
			if (remain == input.charAt(i))
				return i;
		}
		return 0;
	}
}

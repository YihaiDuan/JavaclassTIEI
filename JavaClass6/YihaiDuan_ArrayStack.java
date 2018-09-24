package assignment6;

public class ArrayStack {
	private static final int MAX_NUM = 100;
	private char[] arrayStack = new char[MAX_NUM];
	private int num;
	public ArrayStack() {
		num = 0;
	}
	public boolean isEmpty() {
		return this.num == 0;
	}
	public char peek() {
		return this.arrayStack[num-1];
	}
	public void push (char c) {
		if(this.num<MAX_NUM)
			this.arrayStack[num++] = c;
		//System.out.println(c);
		return;
	}
	public char  pop() {
		if(this.isEmpty())
			return (Character) null;
		char pop = this.arrayStack[--this.num];
		//System.out.println(pop);
		return pop;
	}
}

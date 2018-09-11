package assignment5;
public class SimpleDate {
	private int month;
	private int day;
	private static int [] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
	public SimpleDate (int m,int d) {
		this.month = m;
		this.day = d;
	}
	public SimpleDate (SimpleDate date) {
		this.month = date.month;
		this.day = date.day;
	}
	public int getMonth() {
		return this.month;
	}
	public int getDay() {
		return this.day;
	}
	public String toString() {
		return month + "/" + day;
	}
	public boolean equals(SimpleDate date) {
		return this.month == date.month && this.day == date.day;
	}
	public int daysInMonth() {
		return daysInMonth[this.month-1];
	}
	public void nextDay() {
		if(this.day<this.daysInMonth()) {
			day++;
		}
		else if (this.month != 12) {
			month++;
			day = 1;
		}
		else {
			month = 1;
			day = 1;
		}
		
	}

}

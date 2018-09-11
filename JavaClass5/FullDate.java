package assignment5;

public class FullDate extends SimpleDate {
	private int year;
	private static final int LEAP = 29;
	private static final int NOT_LEAP = 28;
	public FullDate (int y, int m, int d) {
		super(m,d);
		this.year = y;
	}
	public FullDate(FullDate date) {
		super(date.getMonth(),date.getDay());
		this.year = date.getYear();
	}
	public int getYear() {
		return this.year;
	}
	public int daysInMonth() {
		if(this.getMonth() != 2)
			return super.daysInMonth();
		if (this.getYear()%400 == 0)
			return LEAP;
		else if (this.getYear()%100 == 0)
			return NOT_LEAP;
		else if (this.getYear()%4 == 0)
			return LEAP;
		return NOT_LEAP;
	}
	public boolean lessOrEqual(FullDate date) {
		if (this.getYear() == date.getYear()) {
			if(this.getMonth() == date.getMonth()) {
				return this.getDay()<=date.getDay();
			}
				return this.getMonth() < date.getMonth();
		}
		return this.getYear() < date.getYear();
	}
	public String toString() {
		return this.getYear() + "/" + super.toString();
	}
	public boolean equals(FullDate d) {
		return this.getYear()==d.getYear() && super.equals(d);
	}
	public void nextDay() {
		super.nextDay();
		if (this.getMonth()==1 && this.getDay()==1)
			year++;			
	}
}

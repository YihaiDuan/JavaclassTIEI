//
// Introduction to Computer Programming with Java
// TIEI - August 2018
// Author: YihaiDuan
// Student ID: 2018229033
//
package assignment3;

import java.awt.*;
import java.util.*;
import java.io.*;

/**
 * A class for assignment #3
 */
public class RainfallPlotter {

	private static final int MONTH_WIDTH = 70;
	private static final int NAME_WIDTH = 100;
	private static final int HEIGHT = 550;
	private static final int LINE_OFFSET = 25;
	private static final int WIDTH = 12 * MONTH_WIDTH;

	// OPTIONAL: the number of colors determines the maximum number of consecutive plots
	private static final Color[] COLORS = { Color.RED, Color.BLUE, Color.GREEN,Color.ORANGE };
	private static final String STOP = "stop";

	private static final String[] MONTHS_NAME = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
	// Add your own file path here for the file rainfall.txt
	private static final String DATA_FILE = "rainfall.txt";

	/**
	 * The main program
	 * (complete it)
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		DrawingPanel panel = new DrawingPanel(840,550);
		Graphics g = panel.getGraphics();
		
		welcome();
		drawBackground(g);
		String city;
		int num = 0;
		while(num < COLORS.length) {
			System.out.println("city? ");
			city = input.next();
			if (city.equals(STOP))
				break;				
			String lineCity = findCity(city);
			if(!lineCity.equals("NotFound")) {
				drawLine(lineCity,g,num);
				num++;
			}				
		}
		System.out.println("Thanks for using!");
		//System.exit(1);
	}
	public static void welcome() {
		System.out.println("Welcome to the Rainfall Plotter Program!");
		System.out.println("You can plot the rainfall for up to "+COLORS.length+" cities.");
		System.out.println("You can stop plotting by entering '"+STOP+"' as the name of the city!");		
	}
	//draw background of the panel
	public static void drawBackground(Graphics g) {
		g.drawLine(0, LINE_OFFSET, WIDTH, LINE_OFFSET);
		g.drawLine(0, HEIGHT-LINE_OFFSET, WIDTH, HEIGHT-LINE_OFFSET);
		for(int i=1; i<=MONTHS_NAME.length; i++) {
			g.drawLine(MONTH_WIDTH*i, LINE_OFFSET, MONTH_WIDTH*i, HEIGHT);
			g.drawString(MONTHS_NAME[i-1],(i-1)*MONTH_WIDTH+5 , HEIGHT-5);
		}
	}
	//if find the city, return the line of that city. if not, return "NotFound"
	public static String findCity(String city) throws FileNotFoundException {
		Scanner input_file = new Scanner(new File(DATA_FILE));
		while(input_file.hasNextLine()) {
			String line = input_file.nextLine();
			Scanner lineScan = new Scanner(line);
			String city_name = lineScan.next();
			if (city_name.equals(city)) {	
				input_file.close();
				return line;
			}
		}
		System.out.println("Sorry,we didn't find "+ city);
		input_file.close();
		return "NotFound";					
	}
	//draw the polyline of the city
	public static void drawLine(String line,Graphics g,int num) {
		Scanner lineScan = new Scanner(line);
		String city_name = lineScan.next();
		g.setColor(COLORS[num]);
		g.drawString(city_name, num*NAME_WIDTH, 20);
		int math = 0;
		int x_pixel,y_pixel,pre_y_pixel=0;
		double rainfall;
		while(lineScan.hasNextDouble()) {
			math++;
			rainfall = lineScan.nextDouble();
			x_pixel = (math-1)*MONTH_WIDTH;
			y_pixel = getYfromRainfall(rainfall);
			g.drawString(String.valueOf(rainfall), x_pixel, y_pixel);
			if(math>1)
				g.drawLine(x_pixel-MONTH_WIDTH, pre_y_pixel, x_pixel, y_pixel);
			pre_y_pixel = y_pixel;
		}
	}
	//get Y_pixel from the rainfall number.
	public static int getYfromRainfall(double rainfall) {
		return (int)(HEIGHT-LINE_OFFSET*2-rainfall*10/3)+LINE_OFFSET;
	}

}

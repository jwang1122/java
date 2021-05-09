package com.huaxia.ap2021.section2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @see Name
 * 
 * Solution for the question: C:\Users\12818\workspace\apcomputer\exams\sectionII-04.md
 *
 * @author John
 *
 */
public class SeatingChart {
	private String[][] chart;

	SeatingChart(Name[] names, int r, int c) {
		List<Name> list = Arrays.asList(names);
		Collections.shuffle(list);
//		int count = 0;
//		chart = new String[r][c];
//		for (int i = 0; i < chart.length; i++) {
//			for (int j = 0; j < chart[0].length; j++) {
//				chart[i][j] = "";
//				if (count < list.size()) {
//					chart[i][j] = list.get(count++).toString();
//				}
//			}
//		}
		chart = new String[r][c];
		for(int x=0; x<list.size(); x++) {
			chart[x/c][x%c] = list.get(x).toString();
		}
	}

	/** Constructs a SeatinqChart having r rows and c columns. All elements contained in the
	 *  names array should be placed randomly in the chart array using the format: lastName
	 *  first Name (e-g. Johlie, Angelina). Any locations not used in the chart should be  
	 *  initialized to the empty string. 
	 */
	SeatingChart(Name[] names, int r, int c, boolean flag) {
		chart = new String[r][c];
		for (int i = 0; i < chart.length; i++) {
			for (int j = 0; j < chart[0].length; j++) {
				chart[i][j] = "";
			}
		}
		int count = 0;
		int i = (int) (Math.random() * names.length);
		int row = i / c; // one random number determine one seat location
		int col = i % c; 
		int randomTimes=1;
		while (count < names.length) {
			while (!chart[row][col].equals("")) {
				i = (int) (Math.random() * names.length);
				row = i / c;
				col = i % c;
				randomTimes++;
			}
			chart[row][col] = names[count].getLastName() + ", " + names[count].getFirstName();
			count++;
		}
		System.out.println(randomTimes);

	}

	SeatingChart(Name[] names, int r, int c, int flag) {
		chart = new String[r][c];
		for (int i = 0; i < chart.length; i++) {
			for (int j = 0; j < chart[0].length; j++) {
				chart[i][j] = "";
			}
		}
		int randomTimes = 0;
		for (int i = 0; i < names.length; i++) {
			randomTimes+=2;
			int row = (int) (Math.random() * r); // 2 random number determine one seat location
			int col = (int) (Math.random() * c);
			if (chart[row][col].length() == 0) {
				chart[row][col] = names[i].toString();
			} else {
				i--;
			}
		}
		System.out.println(randomTimes);
	}

	/** Returns a string containing all elements of the chart array in row-major order.
	 * The method should return 
	 * a string containing all the elements in the chart array. The method 
	 * padWithSpaces should be called on each
	 * element of chart before it is added to the string to ensure each name will be 
	 * printed with the same
	 * length. Each row of the chart should be separated by a line break.    
	 */
	public String toString() {
		String str = "";
		for (int a = 0; a < chart.length; a++) {
			for (int b = 0; b < chart[a].length; b++) {
				str += padWithSpaces(chart[a][b]);
			}
			str += "\n";
		}
		return str;
	}

	/** pads a string with spaces to ensure each string is exactly 35 characters long. */

	private String padWithSpaces(String s) {
		if(s==null) return "";
		String str = s;
		for (int a = s.length(); a < 20; a++) {
			str += " ";
		}
		return str;
	}

	public static void main(String[] args) {
		String[] names = { "Miller, Minnie", "Fitzgerald,Fred", "Dade, Ali", "Indigo, Inde", "Banner, Boris",
				"Lane, Lois", "Titon, Tim", "Robilard, Robbie", "Georgian, Greg", "Brne, Jane" };
		Name[] theNames = new Name[names.length];
		for (int i = 0; i < names.length; i++) {
			String name = names[i];
			String[] temp = name.split(",");
			Name n = new Name(temp[1], temp[0]);
			theNames[i] = n;
		}
		SeatingChart msJones = new SeatingChart(theNames, 4, 3);
		System.out.println(msJones);
	}
}

package com.huaxia.java1;

/*
 * Homework:
 * output time as 24hours or 12hours format
 * output a integer number to a binary format
 * 
 * Reference to JavaAPI: https://docs.oracle.com/javase/8/docs/api/
 * > java.util.Formatter
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Print2 {

	public static void main(String[] args) {
		String s = String.format("%4$2s %3$2s %2$2s %1$2s", "a", "b", "c", "d");
		System.out.println(s);

		s = String.format("Scientific number is %s.", 15.5e-1);
		System.out.println(s);
		
		s = String.format(Locale.FRANCE, "e = %+10.4f", Math.E);
		System.out.println(s);

		s = String.format("Total ammount $%.2f", 101.99);
		System.out.println(s);

		s = String.format("Amount gained or lost since last statement: $%(,.2f\",\r\n", 16270.126);
		System.out.println(s);

		s = String.format("Local time: %tT", Calendar.getInstance());
		System.out.println(s);

		Calendar c = new GregorianCalendar(1995, 4, 23);
		s = String.format("Duke's Birthday: %1$tb %1$te, %1$tY", c);
		System.out.println(s);
		System.out.println("Done.");
	}

}

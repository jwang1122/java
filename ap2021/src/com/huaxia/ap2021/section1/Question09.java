package com.huaxia.ap2021.section1;

/**
 * 1. Understand the logical operators,
 * &&: both true will return true
 * ||: one true will return true
 * !: toggle the boolean result
 * 2. Understand Boolean Short-circuiting
 * 		if (temp >= 90 && !cloudy) // temp=90 will not check !cloudy
 * @author John
 *
 */
public class Question09 {

	public static void main(String[] args) {
		int temp = 90;
		boolean cloudy = false;
		
		if (temp >= 90 && !cloudy)
			System.out.println(temp >= 90 && !cloudy);
		if (!(temp > 90 || cloudy))
			System.out.println(!(temp > 90 || cloudy));
		if (!(temp >= 90 && !cloudy))
			System.out.println(!(temp >= 90 && !cloudy));

	}

}

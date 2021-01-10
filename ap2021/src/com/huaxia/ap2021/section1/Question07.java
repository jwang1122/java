package com.huaxia.ap2021.section1;

/**
 * if-else if-else, one condition meet, others will not be executed.
 * 
 * @author John
 *
 */
public class Question07 {

	public static void main(String[] args) {
		int x = 10;
		int y = 5;

		if (x == 10)
			if (y <= 5)
				y++;
			else if (y < 4)
				x = 3;
			else
				y += 6;
		if (y > 5)
		{
			if (x != 10) {
				x = 0;
				y = 0;
			} else
				x = -5;
		}
		System.out.printf("x = %d, y = %d\n", x, y);
	}
}

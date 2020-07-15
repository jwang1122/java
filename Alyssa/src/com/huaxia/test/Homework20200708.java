package com.huaxia.test;

public class Homework20200708 {

	public static void main(String[] args) {
		System.out.println("01. 2020 - 20 = " + (2020 - 20));
		System.out.println("02. 494 + 118 = " + (494 + 118));
		System.out.println("03. The tens digit of 129612 is " + (1296 - 1290) / 10);

		String s = "1296";
		System.out.printf("03. The tens digit of %s is %s\n",s, s.charAt(s.length() - 2));

		System.out.println("04. 60/5 = " + (60 / 5));
		System.out.println("05. 14 * 50 = " + (14 * 50));
		System.out.println("06. The remainder of 66/4 is " + (66 % 4));
		System.out.println("07. The product of 14 and 3 is " + (14 * 3));
		System.out.println("08. 8 * 11 + 8 = " + (8 * 11 + 8));
		System.out.println("09. 53 + 12 + 28 + 7 = " + (53 + 12 + 28 + 7));
		System.out.println("10. I don't know how to do it.");

		System.out.println("10. 201+402+804+603 = " + (201 + 402 + 804 + 603));

		System.out.println("11. I don't know.");

		System.out.println("11. 1987 rounded to nearest ten is " + (Math.round(1987 / 10.) * 10));

		System.out.println("12. 17^2 = " + Math.pow(17, 2));
		System.out.println("13. 578 - 361 - 27 = " + (578 - 361 - 27));
		System.out.println("14. 11 * 48 = " + (11 * 48));
		System.out.println("15. 681 - 292 = " + (681 - 292));
		System.out.println("16. 45 * 18 = " + (45 * 18));
		System.out.println("17. Don't know.");
/*
 *  Google Search: Roman Numerals
 *  URL: https://www.mathsisfun.com/roman-numerals.html
 *  Google Search: Parse Roman Numerals
 *  	
 */
		System.out.println("17. DCLXXVI in Roman NUmberals is " + (500 + 100 + 50 + 10 + 10 +5 + 1));
		RomanToNumber roman2number = new RomanToNumber();
		System.out.println("17. DCLXXVI in Roman NUmberals is " + roman2number.romanToDecimal("DCLXXVI"));
		
		System.out.println("18. 37 + 41 + 45 = " + (37 + 41 + 45));
		System.out.println("19. 32 * 28 = " + (32 * 28));
		System.out.println("20. I don't know.");
		
		System.out.println("20. 398*202="+ (398*202));
	}

}

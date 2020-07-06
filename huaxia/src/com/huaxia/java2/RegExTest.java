package com.huaxia.java2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * [abc]: Find one character from the options between the bracket 
 * [^abc]: Find one character NOT between the brackets 
 * [0-9]: Find one character from the range 0 to 9
 * 
 * ^: beginning of the test string $: end of the test string
 * 
 * Quantifier Description 
 * n+ Matches any string that contains at least one n 
 * n* Matches any string that contains zero or more occurrences of n 
 * n? Matches any string that contains zero or one occurrences of n 
 * n{x} Matches any string that contains a sequence of X n's 
 * n{x,y} Matches any string that contains a sequence of X to Y n's 
 * n{x,} Matches any string that contains a sequence of at least X n's
 *
 * @author wangqianjiang
 *
 */
public class RegExTest {

	public static void main(String[] args) {
		RegExTest test = new RegExTest();
//		 test.matchPatternTest();
//		 test.matchBeginingOfLine();
//		 test.validateEmailAddress("^(.+)@(.+)$"); // start any characters with . and @ in the middle, end with any
//		 test.validateEmailAddress("^[A-Za-z0-9_.-]+@(.+)$"); // only start with letters, digits, _, ., -
//		 test.validatePhoneNumber("^(\\d{3}[- .]?){2}\\d{4}$");
//		 test.validatePhoneNumber("^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[-.]?\\d{4}$");
		// neither "000" nor "666" can be matched
		// match digit between 0 and 8
		// match a digit two times
		// followed by -
		// no match for "00"
		// match a digit two times
		// followed by -
		// no match for "0000"
		// match a digit four times.
		test.validateSocialSecurity("^(?!000|666)[0-8][0-9]{2}(-)(?!00)[0-9]{2}(-)(?!0000)[0-9]{4}$");

	}

	private void validateSocialSecurity(String regex) {
		List<String> ssns = new ArrayList<String>();

		// Valid SSNs
		ssns.add("123-45-6789");
		ssns.add("856-45-6789");

		// Invalid SSNs
		ssns.add("000-45-6789");
		ssns.add("666-45-6789");
		ssns.add("901-45-6789");
		ssns.add("85-345-6789");
		ssns.add("856-453-6789");
		ssns.add("856-45-67891");
		ssns.add("856-456789");

		Pattern pattern = Pattern.compile(regex);

		for (String number : ssns) {
			Matcher matcher = pattern.matcher(number);
			System.out.println(matcher.matches());
		}
	}

	void validatePhoneNumber(String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher("202-555-0125");
		System.out.println(matcher.matches());
		matcher = pattern.matcher("(202) 555-0125");
		System.out.println(matcher.matches());
		matcher = pattern.matcher("2025550125");
		System.out.println(matcher.matches());
	}

	void validateEmailAddress(String regex) {
		List<String> emails = new ArrayList<String>();
		emails.add("user@domain.com");
		emails.add("user@domain.co.in");
		emails.add("user.name@domain.com");
		emails.add("user#@domain.co.in");
		emails.add("user@domaincom");
		emails.add("123-abc@yahoo.com");

		// Invalid email
		emails.add("user#domain.com");
		emails.add("@yahoo.com");

		Pattern pattern = Pattern.compile(regex);
		for (String email : emails) {
			System.out.println(addTailSpace(email, 25) + ":" + pattern.matcher(email).matches());
		}
		System.out.println();
	}

	private String addTailSpace(String input, int width) {
		StringBuffer result = new StringBuffer(input);
		int x = width - input.length();
		for (int i = 0; i < x; i++) {
			result.append(" ");
		}
		return result.toString();
	}

	void matchBeginingOfLine() {
		String regEx = "^This";
		Pattern p = Pattern.compile(regEx);
		String testStr = "Is this a book?";
		System.out.println(p.matcher(testStr).find());
		testStr = "This is a book.";
		System.out.println(p.matcher(testStr).find());
	}

	void matchPatternTest() {
		Pattern pattern = Pattern.compile("school", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher("Huaxia Chinese School");
		boolean matchFound = matcher.find();
		if (matchFound) {
			System.out.println("Match found");
		} else {
			System.out.println("Match not found");
		}

	}
}

package com.huaxia.ap2021.section1;

/**
 * memory location and pointer for String object.
 * 
 * @author John
 *
 */
public class Question10 {

	public static void main(String[] args) {
		String dog1 = new String("Poodle");
		String dog2 = new String("Beagle");
		dog1 = dog2; // same box with different label
		String dog3 = new String("Beagle"); // same content with different box
		
		if(dog1==dog2) // compare memory location
			System.out.println("dog1 and dog2 are one and the same dog.");
		else
			System.out.println("dog1 and dog2 are not the same dog.");
		
		if(dog1==dog3) // compare memory location
			System.out.println("dog1 and dog3 are one and the same dog.");
		else
			System.out.println("dog1 and dog3 are not the same dog.");
		
		if(dog1.equals(dog3)) // compare memory contents
			System.out.println("dog1 and dog3 are the same breed.");
		else
			System.out.println("dog1 and dog3 are not the same breed.");
			
	}

}

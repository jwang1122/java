package com.huaxia.apcomputer.exam1;
/**
 * Question 6, 7
 * 
 * Refer to PassByReference.java
 * 
 * @author John
 *
 */
public class Tester {
    private int[] testArray = {3,4,5};

    //Add 1 to n
    public void increment(int n) {
    	n++;
    }
    
    public void firstTestMethod() {
    	for(int i=0; i<testArray.length; i++) {
    		increment(testArray[i]);
    		System.out.print(testArray[i] + " ");
    	}
    }
    
    public void secondTestMethod() {
    	for(int element : testArray) {
    		increment(element);
    		System.out.print(element + " ");
    	}
    }
    
	public static void main(String[] args) {
		Tester test = new Tester();
		test.firstTestMethod();
		System.out.println();
		test.secondTestMethod();

	}

}

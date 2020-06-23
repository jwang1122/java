package com.huaxia.test;

public class ExceptionTest {

	public static void main(String[] args) {
		ExceptionTest test = new ExceptionTest();
//		test.uncheckedArrayUsage();
		test.tryCatchTest();
		System.out.println(test.area(1.0f));
		System.out.println(test.area(-2.0f));

		test.throwExceptionTest();
		System.out.println("Done.");
	}

	private void throwExceptionTest() {
		// TODO Auto-generated method stub
		
	}

	private void tryCatchTest() {
		try {
			uncheckedArrayUsage();
		}catch(Exception e) {
			System.out.println("Error: " + e);
		}
		
	}
	/**
	 * add throw Exception
	 * @param radius
	 * @return
	 */
	private float area(float radius) {
		return (float) (Math.PI * radius * radius);
	}
	

	private void uncheckedArrayUsage() {
		int[] numbers = {1,2,3,4,5};
		System.out.println(numbers[5]);
		
	}

}

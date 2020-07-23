package com.huaxia.john;

//import com.huaxia.john.InvalidValueException;

public class ExceptionTest {

	public static void main(String[] args){
		ExceptionTest test = new ExceptionTest();
//		test.uncheckedArrayUsage();
//		test.tryCatchTest();
		try {
			System.out.println(test.area(-1.0f));
		} catch (Exception e1) {
			System.out.println("Error: " + e1.getMessage());
//			e1.printStackTrace();
		}
		try {
			System.out.println(test.area(-2.0f));
		} catch (Exception e2) {
			System.out.println("Error: " + e2.getMessage());
//			e.printStackTrace();
		}
		try {
			float area = test.area(2.3f);
			System.out.printf("Area of circle with radius %4.2f is %5.2f.\n", 2.3, area);
		} catch (Exception err) {
			System.out.println("Error: " + err);
		}
		System.out.println("Done.");

	}

	void tryCatchTest() {
		try {
			uncheckedArrayUsage();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

	}

	/**
	 * add throw Exception
	 * 
	 * @param radius
	 * @return
	 * @throws Exception
	 * @throws InvalidValueException
	 */
	float area(float radius) throws Exception {
		if (radius < 0) {
			throw new Exception("Circle radius cannot be negative. it is " + radius);
		}
		return (float) (Math.PI * radius * radius);
	}

	void uncheckedArrayUsage() {
		int[] numbers = { 1, 2, 3, 4, 5 };
		System.out.println(numbers[10]);
	}

}

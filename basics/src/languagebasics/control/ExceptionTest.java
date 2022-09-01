package languagebasics.control;

public class ExceptionTest {

	public static void main(String[] args) {
		ExceptionTest test = new ExceptionTest();
//		test.uncheckedArrayUsage();
//		test.tryCatchTest();
		try {
			System.out.println(test.area(1.0f));
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
		}
		try {
			System.out.println(test.area(-2.0f));
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
//			e.printStackTrace();
		}
//		try {
//			float area = test.area(-2.3f);
//			System.out.printf("Area of circle with radius %f is %f.", 2.3, area);
//		} catch (Exception e) {
//			System.out.println("Error: " + e);
//		}
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
	 * @param radius
	 * @return
	 * @throws Exception 
	 * @throws InvalidValueException 
	 */
	float area(float radius) throws Exception {
		if (radius < 0) {
			throw new Exception("Circle radius cannot be negative. it is "+radius);
		}
		return (float) (Math.PI * radius * radius);
	}

	void uncheckedArrayUsage() {
		int[] numbers = { 1, 2, 3, 4, 5 };
		System.out.println(numbers[5]);

	}

}

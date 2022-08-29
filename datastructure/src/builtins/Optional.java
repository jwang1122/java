package builtins;

import java.util.OptionalDouble;

/**
 * Understand OptionalDouble.
 * 
 * @author John
 *
 */
public class Optional {

	public static void main(String[] args) {
		try {

			// Create an OptionalDouble instance
			OptionalDouble opDouble = OptionalDouble.empty();

			System.out.println("OptionalDouble: " + opDouble.toString());

			// Get value in this instance
			// using getAsDouble()
			System.out.println("Value in OptionalDouble = " + opDouble.getAsDouble());
		} catch (Exception e) {

			System.out.println("Exception: " + e);
		}
	}

}

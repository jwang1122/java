package functional;

import java.util.function.Function;

public class CreateFunction04 {

	public static void main(String[] args) {
		// Function which takes in a number
		// and returns half of it
		Function<Double, Double> half = a -> a / 2.0;

        // Try bloc kto check for exceptions
        try {
 
            // Trying to pass null as parameter
            half = half.compose(x->Math.pow(x, 3));
        }
 
        // Catch block to handle exceptions
        catch (Exception e) {
 
            // Print statement
            System.out.println("Exception thrown "
                               + "while passing null: "
                               + e);
        }		
		// Applying the function to get the result
		System.out.println(half.apply(10.));
	}
}
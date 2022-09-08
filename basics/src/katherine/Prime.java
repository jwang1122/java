package katherine;

/**
 * Prime numbers are numbers greater than 1. 
 * They only have two factors, 1 and the number itself.
 * 
 * @author John
 *
 */
public class Prime {

	public static boolean isPrime(int num) {
		boolean flag = true;
		for (int i = 2; i <= num / 2; ++i) {
			// condition for nonprime number
			if (num % i == 0) {
				flag = false;
				break;
			}
		}
		return flag && num!=1;
	}

	public static void main(String[] args) {
		int num = 10;
		System.out.println(isPrime(num));

	}

}

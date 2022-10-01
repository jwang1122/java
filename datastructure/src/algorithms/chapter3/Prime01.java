package algorithms.chapter3;

import java.util.ArrayList;
import java.util.List;

public class Prime01 {
	public static boolean isPrime(int num) {
		boolean flag = true;
		if (num<=1) return false;
//		if (num==2) return true;
//		if(num>2 && num%2==0) return false;
		for(int i=3; i<num; i++) { // num/2 + 1; 1+ Math.floor(Math.sqrt(num))
			if(num % i == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	public static List<Integer> findPrimeBetween(int num1, int num2){
		ArrayList<Integer> result = new ArrayList<>();
		for(int i=num1; i<=num2; i++) {
			if(isPrime(i)) {
				result.add(i);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(isPrime(43));
		StopWatch sw = new StopWatch();
		sw.start();
		List<Integer> primeNumbers = findPrimeBetween(40, 50000); 
		System.out.println(sw.stop());
//		System.out.println(primeNumbers);
		System.out.println(primeNumbers.size());
	}

}

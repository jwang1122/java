package algorithms.chapter2;

public class Problem3 {

	public static void main(String[] args) {
		String text = "A man and a woman";
		int count = PatternMatching.patternMatching(text, "an");
		System.out.println("total comparison time is " + count);	
		System.out.println(text.length()-"an".length() + 1);
	}
}

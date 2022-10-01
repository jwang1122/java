package algorithms.chapter3;

public class PatternMatching {
	
	public static void main(String[] args) {
//		String text = "KLMNPQRSTX";
//		String pattern = "ABC";
//		String text = "AAAAAAAAA";
//		String pattern = "AAAB";
		String text = "AAAAAAAAA";
		String pattern = "AAAA";
		int n = text.length();
		int m = pattern.length();
		int count = n - m + 1;
		int actual = patternMatching(text, pattern);
		System.out.printf("expected: %s, and actual: %s\n", count, actual);
	}

	private static int patternMatching(String text, String pattern) {
		int len = text.length() - pattern.length() + 1;
		int count = 0;
		for(int i=0; i<len; i++) {
			String tmp = text.substring(i, pattern.length()+i);
			count++;
			if(tmp.equals(pattern)) {
				System.out.println("find pattern " + pattern);
			}
		}
		return count;
	}

}

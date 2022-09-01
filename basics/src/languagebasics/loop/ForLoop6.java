package languagebasics.loop;
/*
 * continue on condition
 */
public class ForLoop6 {

	public static void main(String[] args) {
		int c = 4;
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			if (i >= c && i <= c + 2) {
				sum += i;
				continue;
			}
			System.out.println(i);
		}
		System.out.println(sum);
		System.out.println("\nBye...");
	}

}

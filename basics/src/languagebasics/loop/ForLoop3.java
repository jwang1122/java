package languagebasics.loop;
/*
 * negative step
 */
public class ForLoop3 {

	public static void main(String[] args) {
		for (int i = 12, n = 0; i >= 0; i -= 2, n = i * i) {
			System.out.println("n=" + n);
		}
		System.out.println("Bye...");
	}

}

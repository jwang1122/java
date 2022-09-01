package languagebasics.loop;
/*
 * infinite loop, Scanner
 */
import java.util.Scanner;

public class ForLoop7 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		for (int i=1;;i++) {
			System.out.print(i + ": Do you want to continue? (y/n) ");
			String answer = console.nextLine().toLowerCase();
			if(!answer.equals("y"))
				break;
		}
		System.out.println("Bye...");
		console.close();
	}

}

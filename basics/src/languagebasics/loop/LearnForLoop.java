package languagebasics.loop;

public class LearnForLoop {

	public static void main(String[] args) {
		for (int i = 1; i < 5; i++) {
			
			for (int j = 0; j < i; j++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
/*
 * output
* 1
* 2 2
* 3 3 3
* 4 4 4 4
*/

/* in class
 *    1
 *   2 2
 *  3 3 3
 * 4 4 4 4 
 */

/* homework
 *    1
 *   2 2
 *  3 3 3
 * 4 4 4 4 
 *  3 3 3
 *   2 2
 *    1
 */

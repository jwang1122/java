package knowledgebase;

public class MethodTest {
	public static void swap(String s1, String s2) {
		String hold = s1;
		s1 = s2;
		s2 = hold;
	}

	public static void main(String[] args) {
		String animal1 = "elephant";
		String animal2 = "lion";
		swap(animal1, animal2);
		animal1.toUpperCase();
		animal2.toUpperCase();
		System.out.println(animal1 + " " + animal2);
	}
}

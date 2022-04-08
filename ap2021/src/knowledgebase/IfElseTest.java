package knowledgebase;

public class IfElseTest {

	public static void main(String[] args) {
		String dog1 = new String("Poodle");
		String dog2 = new String("Beagle");
		dog1 = dog2;
		String dog3 = new String("Beagle");

		if (dog1 == dog2) // same box with different label
			System.out.println("dog1 and dog2 are one and the same dog.");
		else
			System.out.println("dog1 and dog2 are not the same dog.");

		if (dog1 == dog3) // same content with different box and label
			System.out.println("dog1 and dog3 are one and the same dog.");
		else
			System.out.println("dog1 and dog3 are not the same dog.");

		if (dog1.equals(dog3)) // same content with different box and label
			System.out.println("dog1 and dog3 are the same breed.");
		else
			System.out.println("dog1 and dog3 are not the same breed.");
	}

}

package oop;

public class TestPolymorphism {

	public static void main(String[] args) {
		Teacher t1 = new Teacher();
		Engineer e1 = new Engineer();
		System.out.println("I am a " + showOccupation(t1));
		System.out.println("I am a " + showOccupation(e1));
	}

	private static String showOccupation(Occupation person) { // polymorphism: pass interface to method
		return person.getOccupation();
	}

}

class Teacher implements Occupation{

	@Override
	public String getOccupation() {
		return "Teacher";
	}
	
}

class Engineer implements Occupation{

	@Override
	public String getOccupation() {
		return "Engineer";
	}
	
}
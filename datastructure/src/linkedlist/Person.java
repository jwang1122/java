package linkedlist;

public class Person {
	protected String name;
	protected int age;

	public Person() {		
	}
	
	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}
	
	
}

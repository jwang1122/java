package builtins;

public class Student implements Comparable<Student>{
	String id;
	String name;
	int age;
	
	public Student(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	
	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public int getAge() {
		return age;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}


	@Override
	public int compareTo(Student other) {
		return name.compareTo(other.getName());
	}
}

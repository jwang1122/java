package builtins;

import java.util.Hashtable;

public class MyHashtable {

	public static void main(String[] args) {
		Hashtable<String, Student> students = new Hashtable<>();
		Student s = new Student("1","John",13);
		students.put(s.getId(), s);
		s = new Student("2","David",13);
		students.put(s.getId(), s);
		s = new Student("3","Charles",13);
		students.put(s.getId(), s);
		s = new Student("4","Richard",13);
		students.put(s.getId(), s);
		s = new Student("5","Bob",13);
		students.put(s.getId(), s);
		
		System.out.println(students.get("3"));
	}

}

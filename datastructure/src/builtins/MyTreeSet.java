package builtins;

import java.util.Hashtable;
import java.util.TreeSet;

public class MyTreeSet {

	public static void main(String[] args) {
		TreeSet<Student> set = new TreeSet<>();
		Student s = new Student("1","John",13);
		set.add(s);
		s = new Student("2","David",13);
		set.add(s);
		s = new Student("3","Charles",13);
		set.add(s);
		s = new Student("4","Richard",13);
		set.add(s);
		s = new Student("5","Bob",13);
		set.add(s);

		System.out.println(set);
		
		set.stream().map((s1)->s1.getName()).forEach(System.out::println);
		System.out.println();
		
		for(Student s2: set) {
			System.out.println(s2.getName());
		}
	}

}

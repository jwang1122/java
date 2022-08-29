package builtins;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import linkedlist.Person;

public class MyCollections {

	public static void main(String[] args) {
	    ArrayList<Integer> numbers = new ArrayList<Integer>();
	    numbers.add(5);
	    numbers.add(9);
	    numbers.add(8);
	    numbers.add(1);
	    System.out.println(numbers);
	    Collections.sort(numbers); // it is because Integer implements Comparable
	    System.out.println(numbers);
		
		ArrayList<Person> personList = new ArrayList<>();
		Person p1 = new Person("John");
		Person p2 = new Person("Charles");
		Person p3 = new Person("David");
		Person p4 = new Person("Jimy");
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		personList.add(p4);
		System.out.println(personList);
		Collections.sort(personList, new PersonComparator());
		System.out.println(personList);
		
	}

}

class PersonComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		return o1.getName().compareTo(o2.getName());
	}

}

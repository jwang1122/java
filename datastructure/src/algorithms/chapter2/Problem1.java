package algorithms.chapter2;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {
	public static void main(String[] args) throws Exception{
		List<Person> list = new ArrayList<>();
		Person person = new Person("Smith", "(648) 555-1258");
		list.add(person);
		person = new Person("Jones", "(247) 834-6543");
		list.add(person);
		person = new Person("Adams", "(771) 921-5281");
		list.add(person);
		person = new Person("Doe", "(356) 327-8900");
		list.add(person);
		System.out.printf("Total number of Person is %s\n",list.size());
		Person p = find("(771) 921-5281", list);
		System.out.println(p);
	}

	public static Person find(String phone, List<Person> list) throws NotFoundException{
		long count = 0;
		for(Person p: list) {
			count++;
			if(p.phone.equals(phone)) {
				System.out.printf("compare %s times.\n", count);
				return p;
			}
		}
		throw new NotFoundException("The number not found.");
	}
	
}

class Person{
	String phone;
	String name;
	
	Person(String name, String phone){
		this.name = name;
		this.phone = phone;
	}
	
	public String toString() {
		return name + ": " + phone;
	}
}


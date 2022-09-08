package oop;

public class PetControl {

	public static void main(String[] args) {
//		Pet bob = new Pet();  // the default constructor is used from Object class
//		bob.speak();
		Pet pet1 = new Dog(); // Polymorphism Dog is a Pet, so I can assign Dog to Pet
		System.out.println(pet1);
		System.out.println(pet1.getClass().getName());
		System.out.println(Integer.toHexString(pet1.hashCode()));
		pet1.speak();
		Cat lucky = new Cat("Lucky", 1);  // lucky is instance(object) of a Cat, you create instance first
		lucky.speak();                    // you can use it by dot (.) operator
		System.out.println(lucky);
		
		int c = ((Dog)pet1).add(1,2);     // object cast
		System.out.println(c);
		
		Dog danile = new Dog("Danile", 3);
		c = danile.add(3, 4);
		System.out.println(c);
		danile.speak();
	}

}

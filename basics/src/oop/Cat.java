package oop;

public class Cat extends Pet {
	Cat(){  // default modifier is package level visibility, it is so-called encapsulations.
		super(); // behind the scene, this method will be called anyway.
	}
	
	public Cat(String name, int age){ // constructor always return an instance of this class
		super();    
		this.name = name;
		this.age = age;
		this.species = "Cat";
	}
	

	@Override
	public String toString() {
		return species + "|" + name+": " + age + " years old";
	}

	@Override
	public String speak() {
		return "Meow, Meow, Meow, ...";
	}

	@Override
	protected int add(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}

package oop;

public abstract class Pet extends Object implements LetUsTalk {
	protected String name;
	protected double age;
	protected String species;
	
	protected Pet(){
		super();  // it is the super() which let JRE create a memory for the instance
	}

	protected abstract int add(int x, int y); // because this method is abstract, we do not need provide body.
	
	@Override
	public String speak() { // defined a default behavior for all subclasses
		return "Sorry, I don't know how to speak.";
	}

	
}

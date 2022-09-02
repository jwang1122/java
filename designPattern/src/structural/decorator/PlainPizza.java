package structural.decorator;

public class PlainPizza implements Pizza {

	public PlainPizza() {
		System.out.println("Add dough...");
	}
	@Override
	public String getDescription() {
		return "Thin Dough";
	}

	@Override
	public double getCost() {
		return 4.5;
	}

}

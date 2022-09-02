package structural.decorator;

public class Tomato extends ToppingDecorator {
	public Tomato(Pizza newPizza) {
		super(newPizza);
		System.out.println("Add tomato...");
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pizza.getDescription() + ", Tomato";
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return pizza.getCost() + 0.75;
	}

}

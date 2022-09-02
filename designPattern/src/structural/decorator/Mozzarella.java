package structural.decorator;

public class Mozzarella extends ToppingDecorator {
	public Mozzarella(Pizza newPizza) {
		super(newPizza);
		System.out.println("Add Mozzarella...");
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pizza.getDescription() + ", Mozzarella";
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return pizza.getCost() + 0.5;
	}

}

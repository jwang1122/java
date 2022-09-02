package structural.decorator;

public abstract class ToppingDecorator implements Pizza {
	protected Pizza pizza;
	
	public ToppingDecorator(Pizza newPizza) {
		pizza = newPizza;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pizza.getDescription();
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return pizza.getCost();
	}

}

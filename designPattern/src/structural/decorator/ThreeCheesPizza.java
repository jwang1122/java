package structural.decorator;

public class ThreeCheesPizza extends PizzaNoPattern {
	String description;
	double cost = 10.0;
	
	@Override
	public void setDescription(String newDescription) {
		this.description = newDescription;

	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public double getCost() {
		return 10.00;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "$"+cost+": " + description;
	}

	public static void main(String[] args) {
		ThreeCheesPizza myPizza = new ThreeCheesPizza();
		myPizza.setDescription("Mozzarella, Fontina, Parmesan, Cheese Pizza");
		System.out.println(myPizza);
	}
}

package structural.decorator;

public class PizzaTest {

	public static void main(String[] args) {
		Pizza pizza = new Tomato(new Mozzarella(new PlainPizza()));
		System.out.println(pizza.getDescription());
		System.out.println(pizza.getCost());
	}

}

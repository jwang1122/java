package functional;

import java.util.List;

public class Reduce {

	public static void main(String[] args) {
		// List of cart item benas
		CartItem item1 = new CartItem("apple", 10);
		CartItem item2 = new CartItem("flour", 3);
		CartItem item3 = new CartItem("orange", 11);
		CartItem item4 = new CartItem("banna", 7);
		
		var cartItems = List.of(item1,item2,item3,item4);
		var total = cartItems.stream()                   		// Stream<CartItem>
		         	.map(CartItem::getQuantity) 				// Stream<Integer>
		         	.reduce(0, (Integer acc, Integer current) -> acc += current);
		
		System.out.println(total);
	}

}

class CartItem{
	String name;
	int quantity;
	double price;
	
	public CartItem(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}
	
	
}
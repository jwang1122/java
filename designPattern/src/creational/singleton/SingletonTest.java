package creational.singleton;

public class SingletonTest {

	public static void main(String[] args) {
		BillPughSingleton bps1 = BillPughSingleton.getInstance();
		BillPughSingleton bps2 = BillPughSingleton.getInstance();
		BillPughSingleton bps3 = BillPughSingleton.getInstance();
		
		System.out.println(bps1==bps2);
		System.out.println(bps3==bps2);
	}

}

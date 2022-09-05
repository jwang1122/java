package creational.singleton;

public class BillPughSingleton {
	private int x = 5;
	
    private BillPughSingleton(){}
    
    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    
    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public static void main(String[] args) {
		BillPughSingleton obj1 = BillPughSingleton.getInstance();
		System.out.println(obj1);
		System.out.println(obj1.getX());

		BillPughSingleton obj2 = BillPughSingleton.getInstance();
		System.out.println(obj2);
		System.out.println(obj2.getX());
		obj2.setX(10);
		System.out.println(obj1.getX());
	}

}

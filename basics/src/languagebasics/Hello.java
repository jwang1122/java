package languagebasics;

public class Hello {
	private String name;
	public Hello(String name){
		this.name = name;
	}
	public static void main(String[] args) {
		System.out.println("Hello, World!");
		int z = MyMath.add(12,34); 
		System.out.println(z);
		
//		MyMath mm = new MyMath();
		System.out.println(MyMath.add(11, 9));
		
		Hello h = new Hello("John");
		Test t = h.new Test();
		System.out.println(t.sub(2.4, 9.1));
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	private class Test{
		double sub(double x, double y) {
			return x - y;
		}
	}

}


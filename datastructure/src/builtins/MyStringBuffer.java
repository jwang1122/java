package builtins;

public class MyStringBuffer {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Hello, the world!");
		System.out.println(sb);
		
		StringBuilder sb1 = new StringBuilder("Hello, the world!");
		System.out.println(sb1);
	}
}

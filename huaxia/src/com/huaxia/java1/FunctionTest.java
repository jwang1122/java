package com.huaxia.java1;

public class FunctionTest {

	public static void main(String[] args) {
		FunctionTest test = new FunctionTest();
		System.out.println(test);
		int z = test.add(5,7);
		System.out.println(z);
		float x = test.add(1.2f, 4.5f);
		System.out.println(x);
	}

	/**
	 * overload method (Same name with different signature)
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	int add(int x, int y) {
		return x + y;
	}
	
	/**
	 * overload method (Same name with different signature)
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	float add(float x, float y) {
		return x + y;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "" + getClass() + ", hashCode()=" + hashCode()+"]";
	}
	
	
}

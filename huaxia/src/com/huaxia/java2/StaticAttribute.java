package com.huaxia.java2;

public class StaticAttribute {
	static int staticAttribute = 5;
	
	public static int getStaticAttribute() {
		return staticAttribute;
	}

	public static void setStaticAttribute(int staticAttribute) {
		StaticAttribute.staticAttribute = staticAttribute;
	}

	public static void main(String[] args) {
		StaticAttribute obj1 = new StaticAttribute();
		System.out.println(obj1.getStaticAttribute());

		StaticAttribute obj2 = new StaticAttribute();
		System.out.println(obj2.getStaticAttribute());
		
		obj2.setStaticAttribute(100);
		System.out.println(obj1.getStaticAttribute());
	}

}

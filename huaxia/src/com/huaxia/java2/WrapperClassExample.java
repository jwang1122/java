package com.huaxia.java2;

public class WrapperClassExample {
	public static void main(String args[]) {
		byte x = 0;
//wrapping byte primitive type into Byte object   
		Byte byteobj = new Byte(x);
		int y = 23;
//wrapping int primitive type into Integer object   
		Integer intobj = new Integer(y);
		char c = 'm';
//wrapping char primitive type into Character object    
		Character charobj = c;
//printing values from objects   
		System.out.println("Byte object byteobj: " + byteobj);
		System.out.println("Integer object intobj: " + intobj);
		System.out.println("Character object charobj: " + charobj);
	}
}
package com.huaxia.java2.functional;

public class AddThree implements MyFunction<Long, Long> {
	public static void main(String[] args) {
		MyFunction<Long, Long> adder = new AddThree();
		Long result = adder.apply(4L);
		System.out.println("result = " + result);
	}

	@Override
	public Long apply(Long parameter) {
		return parameter + 3L;
	}
}

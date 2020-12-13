package com.huaxia.learnrxjava;

import java.util.HashMap;
import java.util.Map;

public class MultipleReturn1 {
	public static Map<String, Object> divide(int x, int y) {
		Map<String, Object> result = new HashMap<String, Object>();
		if (y == 0) {
			result.put("exception", new Exception("div by zero"));
			return result;
		}
		result.put("answer", (double) x / y);
		return result;
	}

	public static void main(String[] args) {
		Map<String, Object> result = divide(10, 5);
		System.out.println(result.get("answer"));
		result = divide(10, 0);
		System.out.println(result.get("answer"));
		System.out.println(((Exception)result.get("exception")).getMessage());
	}

}

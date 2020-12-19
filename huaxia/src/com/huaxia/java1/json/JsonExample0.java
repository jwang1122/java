package com.huaxia.java1.json;

import com.google.gson.JsonObject;

public class JsonExample0 {
	public static void main(String args[]) {
		JsonObject obj = new JsonObject();
		obj.addProperty("name", "sonoo");
		obj.addProperty("age", 27);
		obj.addProperty("salary", 600000.0);
		System.out.print(obj);
	}
}
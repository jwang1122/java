package com.huaxia.java1.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.huaxia.java1.Student;
/*
 * from object to Json String.
 */
public class JsonExample2 {

	public static void main(String[] args) {
		GsonBuilder builder = new GsonBuilder();

		builder.serializeNulls(); // make null field serializable

		Gson gson = builder.create();

		Student s1 = new Student(1234,"John",null,100);
		String json = gson.toJson(s1);
		System.out.println(json);	
	}

}

package com.huaxia.java1;

import com.google.gson.Gson;

/*
 * Build Student class object from Json String.
 */
public class JsonExample4 {

	public static void main(String[] args) {
		String studentJson = "[{'firstName': 'Alex','id': 1,'lastName':'Wang','score'=89}, " 
				+ "{'firstName': 'Brian','id':2,'lastName':'Johnson','score':90}, "
				+ "{'firstName': 'Charles','id': 3,'lastName':'Pang','score':99}]";

		Gson gson = new Gson();

		Student[] studentArray = gson.fromJson(studentJson, Student[].class);

		for (Student student : studentArray) {
			System.out.println(student);
		}
		
		
	}

}

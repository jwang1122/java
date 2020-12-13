package com.huaxia.java2.annotation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JsonSerializerTest {
	Person person = new Person("john", "wang", "23");
	JsonSerializer converter = new JsonSerializer();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		String jsonString="";
		try {
			jsonString = converter.convertToJson(person);
		} catch (JsonSerializationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(jsonString, "{\"personAge\":\"23\",\"firstName\":\"John\",\"lastName\":\"Wang\"}");
	}

}

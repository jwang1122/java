package com.huaxia.java2.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class JsonSerializer {
	public String convertToJson(Object object) throws JsonSerializationException {
		try {
			checkIfSerializable(object);
			initializeObject(object);
			return getJsonString(object);
		} catch (Exception e) {
			throw new JsonSerializationException(e.getMessage());
		}
	}

	private void checkIfSerializable(Object object) throws JsonSerializationException {
		if (Objects.isNull(object)) {
			throw new JsonSerializationException("The object to serialize is null");
		}

		Class<?> clazz = object.getClass();
		if (!clazz.isAnnotationPresent(JsonSerializable.class)) {
			throw new JsonSerializationException("The class " + clazz.getSimpleName()
					+ " is not annotated with JsonSerializable");
		}
	}

	private void initializeObject(Object object) throws Exception {
		Class<?> clazz = object.getClass();
		for (Method method : clazz.getDeclaredMethods()) {
			if (method.isAnnotationPresent(Init.class)) {
				method.setAccessible(true);
				method.invoke(object);
			}
		}
	}

	private String getJsonString(Object object) throws Exception {
		Class<?> clazz = object.getClass();
		Map<String, String> jsonElementsMap = new HashMap<>();
		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(JsonElement.class)) {
				jsonElementsMap.put(getKey(field), (String) field.get(object));
			}
		}

		String jsonString = jsonElementsMap.entrySet().stream().map(entry -> "\"" + entry.getKey() + "\":\""
				+ entry.getValue() + "\"").collect(Collectors.joining(","));
		return "{" + jsonString + "}";
	}

	private String getKey(Field field) {
		if (field.getAnnotation(JsonElement.class).key().length() == 0) {
			return field.getName();
		}
		return field.getAnnotation(JsonElement.class).key();
	}

	public static void main(String[] args) throws JsonSerializationException {
		JsonSerializer converter = new JsonSerializer();
		Person p = new Person("john", "wang", "32");
		String jsonString = converter.convertToJson(p);
		System.out.println(jsonString);

	}

}

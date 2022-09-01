package languagebasics.fileio;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import languagebasics.Student;

public class JsonExample1 {

	public static void main(String[] args) {
		String json = "{\"id\":\"11223344\", \"firstName\": \"John\", \"lastName\":\"Wang\", \"score\":98}";

		Student student = jsonConverter(json);
		prettyPrint(student);
//		excludeField(student);
	}

	private static Student jsonConverter(String json) {
		Gson gson = new Gson();

		Student student = gson.fromJson(json, Student.class);
		System.out.println(student);

		String studentJson = gson.toJson(student);
		System.out.println(studentJson);

		return student;
	}

	static void prettyPrint(Student student) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String studentJson = gson.toJson(student);
		System.out.println(studentJson);
	}

	static void excludeField(Student student) {
		ExclusionStrategy exclusionStrategy = new ExclusionStrategy() {
			public boolean shouldSkipField(FieldAttributes fieldAttributes) {
				if ("score".equals(fieldAttributes.getName())) {
					return true;
				}
				return false;
			}

			public boolean shouldSkipClass(Class aClass) {
				return false;
			}
		};
		GsonBuilder builder = new GsonBuilder();
		builder.setExclusionStrategies(exclusionStrategy);
		Gson gson = builder.setPrettyPrinting().create();
		String studentJson = gson.toJson(student);
		System.out.println(studentJson);

	}

}

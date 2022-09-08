package languagebasics.fileio;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@SuppressWarnings("deprecation")
public class JsonFileTest {
	public static void main(String[] args) {
		JsonFileTest test = new JsonFileTest();
		//		test.jsonWrite();
		test.jsonRead();
		System.out.println("Done.");
	}

	void jsonWrite() {
		//First Employee
		JSONObject employeeDetails = new JSONObject();
		employeeDetails.put("firstName", "Lokesh");
		employeeDetails.put("lastName", "Gupta");
		employeeDetails.put("website", "howtodoinjava.com");

		JSONObject employeeObject = new JSONObject();
		employeeObject.put("employee", employeeDetails);

		//Second Employee
		JSONObject employeeDetails2 = new JSONObject();
		employeeDetails2.put("firstName", "Brian");
		employeeDetails2.put("lastName", "Schultz");
		employeeDetails2.put("website", "example.com");

		JSONObject employeeObject2 = new JSONObject();
		employeeObject2.put("employee", employeeDetails2);

		//Add employees to list
		JSONArray employeeList = new JSONArray();
		employeeList.add(employeeObject);
		employeeList.add(employeeObject2);

		//Write JSON file
		try (FileWriter file = new FileWriter("employees.json")) {

			file.write(employeeList.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void jsonRead() {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("employees.json"));
			JSONArray employees = (JSONArray) obj;
			Iterator iterator = employees.iterator();
			while (iterator.hasNext()) {
				JSONObject jsonObject = (JSONObject) iterator.next();
				JSONObject employee = (JSONObject) jsonObject.get("employee");
				System.out.println(employee.get("firstName"));
				System.out.println(employee);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
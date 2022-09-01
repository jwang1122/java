package languagebasics.fileio;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.*;
/**
 * Use HashMap to generate json string
 * @author John
 *
 */
public class JsonExample3 {
	public static void main(String args[]) {
		Gson gson = new Gson();
		Map<String, Object> obj = new HashMap<>();
		obj.put("name", "sonoo");
		obj.put("age", 27);
		obj.put("salary", 600000.0);
		String jsonText = gson.toJson(obj);
		System.out.print(jsonText);
	}
}
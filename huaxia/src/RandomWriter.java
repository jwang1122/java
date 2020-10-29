import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.io.*;
import java.nio.file.Files;


public class RandomWriter {
	static int seed = 5;
	static int size = 2;
	static int num = 100;
	public static void main(String[] args) {
//		Scanner input = new Scanner(System.in);
//		System.out.println("Enter the seed value:");
//		seed = input.nextInt();
//		System.out.println("Enter the size of N-Gram:");
//		size = input.nextInt();
//		System.out.println("Enter the number of words to generate(0 to quit)?");
//		num = input.nextInt();
		List<String> dictionary = readDictionaryFrom("hamlet.txt");
		HashMap<String, List<String>> map = buildMap(dictionary);
//		ArrayList<String> monkeyText = generateTextFrom(dictionary);
		writeTextToFile(map, "final.txt");
//		input.close();
	}

	private static void writeTextToFile(HashMap<String, List<String>> map, String string) {
		// TODO Auto-generated method stub

	}

	public static List<String> readDictionaryFrom(String path) {
		List<String> lines = null;
		try {
			lines = Files.readAllLines(new File(path).toPath());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		int size = lines.size();
		List<String> result = new ArrayList<String>();
		for(int i=0; i<size; i++){
			String line = lines.get(i);
			String[] words = line.split(" ");
			for(int j=0; j<words.length; j++) {
				String w = words[j];
				if(w.endsWith(",")) {
					result.add(w.substring(0,w.length()-1));
					result.add(",");
				}else if(w.endsWith(":")) {
					result.add(w.substring(0,w.length()-1));
					result.add(":");
				}else if(w.endsWith(".")) {
					result.add(w.substring(0,w.length()-1));
					result.add(".");
				}else if(w.endsWith("?")) {
					result.add(w.substring(0,w.length()-1));
					result.add("?");
				}else {
					result.add(words[j]);
				}
			}
		}
		return result;
	}

	public static HashMap<String, List<String>> buildMap(List<String> list){
		HashMap<String, List<String>> map = new HashMap<>();
		for(int i=0; i<list.size(); i++) {
			String window = list.get(i) + " " + list.get(i+1);
			String follower = list.get(i+2);
			if(map.containsKey(window)) {
				List<String> value = map.get(window);
				value.add(follower);
			}else {
				List<String> newList = new ArrayList<String>();
				newList.add(follower);
				map.put(window, newList);
			}
		}
		return map;
	}
	
	public void RandomString(ArrayList<String> text, String path) {
		try (BufferedWriter file = new BufferedWriter(new FileWriter(new File(path)))) {
			for (String word : text) {
				file.write(word + " ");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static ArrayList<String> generateTextFrom(List<String> words) {
		Random generator = new Random();
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			int random = generator.nextInt(words.size());
			result.add(words.get(random));
		}
		return result;
	}

}

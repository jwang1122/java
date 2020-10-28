import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.*;
import java.nio.file.Files;


public class RandomWriter {
	static int seed = 0;
	static int size = 0;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the seed value:");
		seed = input.nextInt();
		System.out.println("Enter the size of N-Gram:");
		size = input.nextInt();
		System.out.println("Enter the number of words to generate(0 to quit)?");
		List<String> dictionary = readDictionaryFrom("basicWordsInEnglish.txt");
		ArrayList<String> monkeyText = generateTextFrom(dictionary);
		writeTextToFile(monkeyText, "final.txt");
		input.close();
	}

	private static void writeTextToFile(ArrayList<String> monkeyText, String string) {
		// TODO Auto-generated method stub

	}

	public static List<String> readDictionaryFrom(String path) {
		List<String> result = null;
		try {
			result = Files.readAllLines(new File(path).toPath());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return result;
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

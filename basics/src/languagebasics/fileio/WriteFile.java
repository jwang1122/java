package languagebasics.fileio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("data/Hello.txt"));
		bw.write("Hello, the world.\n");
		bw.write("Second Line.\n");
		bw.write("Third Line.\n");
		bw.write("Forth Line.\n");
		bw.close();
		System.out.println("Done.");
	}

}

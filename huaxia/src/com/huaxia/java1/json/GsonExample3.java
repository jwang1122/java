package com.huaxia.java1.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huaxia.java1.Book;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class GsonExample3 {

	public static void main(String[] args) {

		Gson gson = new Gson();

		try (Reader reader = new FileReader("books.json")) {

			// Convert JSON File to Java Object
			List<Book> list = gson.fromJson(reader, new TypeToken<ArrayList<Book>>() {
			}.getType());

			// print staff
			for (Book book : list)
				System.out.println(book);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
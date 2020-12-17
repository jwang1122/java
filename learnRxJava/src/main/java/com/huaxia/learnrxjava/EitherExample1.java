package com.huaxia.learnrxjava;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import fj.data.Either;

public class EitherExample1 {
	public static void main(String[] args) {
		String filename = "books.json";
		final Either<Exception, List<Book>> either = get(filename);
		if (either.isRight()) {
			for (Book book : either.right().value())
				System.out.println(book);
		} else {
			System.out.println(either.left().value());
		}
		System.out.println("Done.");
	}

	static final Either<Exception, JsonNode> parse(final String jsonString) {
		try {
			return Either.right(new ObjectMapper().readValue(jsonString, JsonNode.class));
		} catch (Exception e) {
			return Either.left(e);
		}
	}

	static final Either<Exception, List<Book>> get(final String urlString) {
		Gson gson = new Gson();

		try (Reader reader = new FileReader("books.json")) {
			// Convert JSON File to Java Object
			List<Book> list = gson.fromJson(reader, new TypeToken<ArrayList<Book>>() {
			}.getType());
			return Either.right(list);
		} catch (Exception e) {
			return Either.left(e);
		}
	}
}
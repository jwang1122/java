package functional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {

	public static void main(String[] args) {
		
		List<Album> albums = buildAlbums();
		List<String> result1 = findByYearAndGenre(albums);
		System.out.println(result1);
		List<String> result = 
			    albums.stream()
			          .filter(album -> album.getYear() == 1999)
			          .filter(album -> album.getGenre() == Genre.ALTERNATIVE)
			          .limit(5)
			          .map(Album::getName)
			          .sorted()
			          .collect(Collectors.toList());
		System.out.println(result);
	}

	private static List<String> findByYearAndGenre(List<Album> albums) {
		List<String> result = new ArrayList<>();
		for (Album album : albums) {

		    if (album.getYear() != 1999) {
		        continue;
		    }

		    if (album.getGenre() != Genre.ALTERNATIVE) {
		        continue;
		    }

		    result.add(album.getName());

		    if (result.size() == 5) {
		        break;
		    }
		}

		Collections.sort(result);
		return result;
	}

	private static List<Album> buildAlbums() {
		List<Album> albums = new ArrayList<>();
		Album a1 = new Album("hello", Genre.ALTERNATIVE, 1968);
		albums.add(a1);
		a1 = new Album("album1", Genre.ENTERTAIN, 1999);
		albums.add(a1);
		a1 = new Album("album2", Genre.FICTION, 2020);
		albums.add(a1);
		a1 = new Album("album3", Genre.ENTERTAIN, 2022);
		albums.add(a1);
		a1 = new Album("album4", Genre.ALTERNATIVE, 1999);
		albums.add(a1);
		a1 = new Album("album5", Genre.FICTION, 1968);
		albums.add(a1);
		
		return albums;
	}

	
}

enum Genre{
	ALTERNATIVE, FICTION, ENTERTAIN
}
class Album{
	Genre genre;
	int year;
	String name;
	
	public Album(String name, Genre genre, int year) {
		this.name = name;
		this.genre = genre;
		this.year = year;
	}

	public Genre getGenre() {
		return genre;
	}

	public int getYear() {
		return year;
	}

	public String getName() {
		return name;
	}
	
	
}
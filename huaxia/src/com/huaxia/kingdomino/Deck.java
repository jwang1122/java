package com.huaxia.kingdomino;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Deck {
	private ArrayList<Tile> deck = new ArrayList<Tile>();
	private int cursor = 0;
	
	public Deck() {
		loadTilePairFromFile("dominos.csv");
		shuffle();
	}
	/**
	 * 
	 * @return 4 tiles list, if cursor>=48, return empty list, the game over
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Tile> getTileList4Selection(){
		ArrayList<Tile> list = new ArrayList<>();
		if(cursor>=48) return list;
		for(int i=0; i<4; i++) {
			list.add(deck.get(cursor++));
		}
		Collections.sort(list);
		return list;
	}
	
	public ArrayList<Tile> shuffle(){
		Collections.shuffle(deck);
		return deck;
	}
	
	public void loadTilePairFromFile(String filename) {
		try {
			Scanner input = new Scanner(new File(filename));
			input.nextLine(); // skip first header line in the file
			while (input.hasNextLine()) {
				String line = input.nextLine();
				Tile tile = parseLine(line);
				deck.add(tile);
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Tile parseLine(String line) {
		String[] data = line.split(",");
		data[1] = convert(data[1]);
		data[3] = convert(data[3]);
		Tile tile = new Tile(Integer.parseInt(data[4]), Integer.parseInt(data[0]), Integer.parseInt(data[2]),
				data[1].charAt(0), data[3].charAt(0));
		return tile;
	}

	private String convert(String value) {
		String result = "";
		switch (value) {
		case "Champs":
			result = "P";
			break;
		case "Mer":
			result = "W";
			break;
		case "Foret":
			result = "F";
			break;
		case "Prairie":
			result = "L";
			break;
		case "Mine":
			result = "Q";
			break;
		case "Montagne":
			result = "M";
			break;
		}
		return result;
	}

	public ArrayList<Tile> getDeck() {
		return deck;
	}
}

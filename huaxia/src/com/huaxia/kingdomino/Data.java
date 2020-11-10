package com.huaxia.kingdomino;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {
	ArrayList<Tile> deck = new ArrayList<Tile>();

	public Data() {
		File file = new File("dominos.csv");
		Scanner sc;
		{
			try {
				sc = new Scanner(file);
				sc.nextLine();
				while (sc.hasNextLine()) {
					String[] line = sc.nextLine().split(",");
					if (line[1].equals("Champs")) {
						line[1] = "P";
					} else if (line[1].equals("Mer")) {
						line[1] = "W";
					} else if (line[1].equals("Foret")) {
						line[1] = "F";
					} else if (line[1].equals("Prairie")) {
						line[1] = "L";
					} else if (line[1].equals("Mine")) {
						line[1] = "Q";
					} else if (line[1].equals("Montagne")) {
						line[1] = "M";
					} else {
						line[1] = "?";
						System.out.println("?");
					}
					if (line[3].equals("Champs")) {
						line[3] = "P";
					} else if (line[3].equals("Mer")) {
						line[3] = "W";
					} else if (line[3].equals("Foret")) {
						line[3] = "F";
					} else if (line[3].equals("Prairie")) {
						line[3] = "L";
					} else if (line[3].equals("Mine")) {
						line[3] = "Q";
					} else if (line[3].equals("Montagne")) {
						line[3] = "M";
					} else {
						line[3] = "?";
						System.out.println("?");
					}
					this.deck.add(new Tile(Integer.parseInt(line[4]), Integer.parseInt(line[0]),
							Integer.parseInt(line[2]), line[1].charAt(0), line[3].charAt(0)));
				}
				sc.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();

			}
		}
	}

	public ArrayList<Tile> getDeck() {
		return this.deck;
	}

}
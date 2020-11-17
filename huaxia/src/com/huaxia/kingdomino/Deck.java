package com.huaxia.kingdomino;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.huaxia.kingdomino.Terrain.TerrainImage;

public class Deck {
	ArrayList<Domino> deck = new ArrayList<Domino>();

	public Deck() {
		File file = new File("dominos.csv");
		Scanner sc;
		try {
			sc = new Scanner(file);
			sc.nextLine(); // get rid of header line
			TerrainImage image1 = TerrainImage.EMPTY;
			TerrainImage image2 = TerrainImage.EMPTY;
			while (sc.hasNextLine()) {
				String[] line = sc.nextLine().split(",");

				int crown1 = Integer.parseInt(line[0]);
				image1 = getImage(line[1]);
				Terrain terrain1 = new Terrain(image1, crown1);

				int crown2 = Integer.parseInt(line[2]);
				image2 = getImage(line[3]);
				Terrain terrain2 = new Terrain(image2, crown2);

				int number = Integer.parseInt(line[4]);
				Domino tile = new Domino(number, terrain1, terrain2);
				
				this.deck.add(tile);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private TerrainImage getImage(String type) {
		switch (type) {
		case "Champs":
			return TerrainImage.SWAMP;
		case "Mer":
			return TerrainImage.WATER;
		case "Foret":
			return TerrainImage.FOREST;
		case "Prairie":
			return TerrainImage.FIELD;
		case "Mine":
			return TerrainImage.MOUNTAIN;
		case "Montagne":
			return TerrainImage.MINE;
		}
		return TerrainImage.EMPTY;
	}

	public ArrayList<Domino> getDeck() {
		Collections.shuffle(deck);
		return deck;
	}
}
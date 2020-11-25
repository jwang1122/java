package com.huaxia.kingdomino;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.huaxia.kingdomino.Terrain.TerrainImage;

public class Deck {
	ArrayList<Domino> dominoList = new ArrayList<Domino>();

	public Deck() {
		InputStream is = Deck.class.getResourceAsStream("dominos.csv");

		Scanner sc;
		sc = new Scanner(is);
		sc.nextLine(); // get rid of header line
		TerrainImage image1 = TerrainImage.EMPTY;
		TerrainImage image2 = TerrainImage.EMPTY;
		while (sc.hasNextLine()) {
			String[] line = sc.nextLine().split(",");

			int number = Integer.parseInt(line[4]);

			int crown1 = Integer.parseInt(line[0]);
			image1 = getImage(line[1]);
			Terrain terrain1 = new Terrain(image1, crown1);

			int crown2 = Integer.parseInt(line[2]);
			image2 = getImage(line[3]);
			Terrain terrain2 = new Terrain(image2, crown2);

			Domino domino = new Domino(number, terrain1, terrain2);

			dominoList.add(domino);
		}
		sc.close();
	}

	private TerrainImage getImage(String type) {
		switch (type) {
		case "Swamp":
			return TerrainImage.SWAMP;
		case "Water":
			return TerrainImage.WATER;
		case "Forest":
			return TerrainImage.FOREST;
		case "Field":
			return TerrainImage.FIELD;
		case "Mountain":
			return TerrainImage.MOUNTAIN;
		case "Mine":
			return TerrainImage.MINE;
		}
		return TerrainImage.EMPTY;
	}

	public ArrayList<Domino> getNextDominoSet() {
		ArrayList<Domino> dominoSet = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			dominoSet.add(dominoList.get(0));
			dominoList.remove(0);
		}
		Collections.sort(dominoSet);
		return dominoSet;
	}

	public int getDeckSize() {
		return dominoList.size();
	}

	public Deck shuffle() {
		Collections.shuffle(dominoList);
		return this;
	}
}
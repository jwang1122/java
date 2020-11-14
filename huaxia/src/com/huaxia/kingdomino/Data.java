package com.huaxia.kingdomino;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.huaxia.kingdomino.Terrain.TerrainImage;

public class Data {
	ArrayList<Tile> deck = new ArrayList<Tile>();

	public Data() {
		File file = new File("dominos.csv");
		Scanner sc;
		{
			try {
				sc = new Scanner(file);
				sc.nextLine();
				TerrainImage image1 = TerrainImage.EMPTY;
				TerrainImage image2 = TerrainImage.EMPTY;
				while (sc.hasNextLine()) {
					String[] line = sc.nextLine().split(",");
					if (line[1].equals("Champs")) {
						image1 = TerrainImage.SWAMP;
						line[1] = "P";
					} else if (line[1].equals("Mer")) {
						image1 = TerrainImage.WATER;
						line[1] = "W";
					} else if (line[1].equals("Foret")) {
						image1 = TerrainImage.FOREST;
						line[1] = "F";
					} else if (line[1].equals("Prairie")) {
						image1 = TerrainImage.FIELD;
						line[1] = "L";
					} else if (line[1].equals("Mine")) {
						image1 = TerrainImage.MOUNTAIN;
						line[1] = "Q";
					} else if (line[1].equals("Montagne")) {
						image1 = TerrainImage.MINE;
						line[1] = "M";
					} else {
						line[1] = "?";
						System.out.println("?");
					}
					if (line[3].equals("Champs")) {
						image2 = TerrainImage.SWAMP;
						line[3] = "P";
					} else if (line[3].equals("Mer")) {
						image2 = TerrainImage.WATER;
						line[3] = "W";
					} else if (line[3].equals("Foret")) {
						image2 = TerrainImage.FOREST;
						line[3] = "F";
					} else if (line[3].equals("Prairie")) {
						image2 = TerrainImage.FIELD;
						line[3] = "L";
					} else if (line[3].equals("Mine")) {
						image2 = TerrainImage.MOUNTAIN;
						line[3] = "Q";
					} else if (line[3].equals("Montagne")) {
						image2 = TerrainImage.MINE;
						line[3] = "M";
					} else {
						line[3] = "?";
						System.out.println("?");
					}
					Terrain terrain1 = new Terrain(image1, Integer.parseInt(line[0]));
					Terrain terrain2 = new Terrain(image2, Integer.parseInt(line[2]));
					Tile tile = new Tile(Integer.parseInt(line[4]), terrain1, terrain2);
					this.deck.add(tile);
				}
				sc.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();

			}
		}
	}

	public ArrayList<Tile> getDeck() {
		Collections.shuffle(deck);
		return deck;
	}

}
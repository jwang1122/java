package com.huaxia.kingdomino;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

	Player player1;
	Player player2;
	Player player3;
	Player player4;
	ArrayList<Player> list;
	
	@BeforeEach
	void setUp() throws Exception {
		player1 = new Player(Player.PlayerColor.BluePlayer);
		player2 = new Player(Player.PlayerColor.GreenPlayer);
		player3 = new Player(Player.PlayerColor.YellowPlayer);
		player4 = new Player(Player.PlayerColor.RedPlayer);
		list = new ArrayList<Player>();
		list.add(player1);
		list.add(player2);
		list.add(player3);
		list.add(player4);
		
	}

	@Test
	void testMaxScore() {
		int[] scores1 = new int[3];
		scores1[0] = 30;
		scores1[1] = 5;
		scores1[2] = 9;
		player1.setScores(scores1);
		int[] scores2 = new int[3];
		scores2[0] = 20;
		scores2[1] = 5;
		scores2[2] = 9;
		player2.setScores(scores2);
		int[] scores3 = new int[3];
		scores3[0] = 40;
		scores3[1] = 5;
		scores3[2] = 9;
		player3.setScores(scores3);
		int[] scores4 = new int[3];
		scores4[0] = 25;
		scores4[1] = 5;
		scores4[2] = 9;
		player4.setScores(scores4);
		Collections.sort(list);
		assertEquals(player3, list.get(0));
	}
	
	@Test
	void testMaxField() {
		int[] scores1 = new int[3];
		scores1[0] = 30;
		scores1[1] = 6;
		scores1[2] = 9;
		player1.setScores(scores1);
		int[] scores2 = new int[3];
		scores2[0] = 30;
		scores2[1] = 5;
		scores2[2] = 9;
		player2.setScores(scores2);
		int[] scores3 = new int[3];
		scores3[0] = 30;
		scores3[1] = 5;
		scores3[2] = 9;
		player3.setScores(scores3);
		int[] scores4 = new int[3];
		scores4[0] = 30;
		scores4[1] = 8;
		scores4[2] = 9;
		player4.setScores(scores4);
		Collections.sort(list);
		assertEquals(player4, list.get(0));		
	}

	@Test
	void testMaxCrown() {
		int[] scores1 = new int[3];
		scores1[0] = 30;
		scores1[1] = 5;
		scores1[2] = 9;
		player1.setScores(scores1);
		int[] scores2 = new int[3];
		scores2[0] = 30;
		scores2[1] = 5;
		scores2[2] = 6;
		player2.setScores(scores2);
		int[] scores3 = new int[3];
		scores3[0] = 30;
		scores3[1] = 5;
		scores3[2] = 3;
		player3.setScores(scores3);
		int[] scores4 = new int[3];
		scores4[0] = 30;
		scores4[1] = 5;
		scores4[2] = 5;
		player4.setScores(scores4);
		Collections.sort(list);
		assertEquals(player1, list.get(0));				
	}
}

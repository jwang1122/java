package com.huaxia.kingdomino;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.huaxia.kingdomino.Message.MsgType;
import com.huaxia.kingdomino.Player.PlayerColor;

class MessageTest {

	Player player = new Player(PlayerColor.BluePlayer, null);
	Message msg1 = new Message(player, MsgType.NO_SAME_TERRAIN, 23);
	Message msg2 = new Message(player, MsgType.SUCCESS, 23);
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetMessage() {
		String result = msg1.msg;
		System.out.println(result);
		String expected = String.format(Message.NO_SAME_TERRAIN, player.name, 23);
		assertEquals(result, expected);
		assertFalse(msg1.success);

		result = msg2.msg;
		System.out.println(result);
		expected = String.format(Message.SUCCESS, player.name, 23);
		assertEquals(result, expected);
		assertTrue(msg2.success);
	}

}

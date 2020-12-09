package com.huaxia.kingdomino;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.huaxia.kingdomino.Message.MsgType;
import com.huaxia.kingdomino.Player.PlayerColor;

class MessageTest {
	Message msg;
	Player player;
	
	@BeforeEach
	void setUp() throws Exception {
		player = new Player(PlayerColor.BluePlayer);
		msg = new Message(MsgType.OCCUPIED, player);
	}

	@Test
	void testGetMessageFormat() {
		String result = msg.getMessageFormat(MsgType.OCCUPIED);
		assertEquals(result, Message.OCCUPIED);
	}

}

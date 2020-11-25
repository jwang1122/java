package com.huaxia.kingdomino;

public class Message {
	static final String SUCCESS = "\n%s, you have score of %d points.";
	static final String DIAGONAL = "\n%s, the domino you have choosen cannot be placed due to diagonal location choosen!";
	static final String OCCUPIED= "\n%s, the domino you have choosen cannot be placed due to locations occupied!";
	static final String OUTSIDE_FRAME= "\n%s, the domino you have choosen cannot be placed due to out of 5X5 frame! \nSo you keep the score of %d points.\nTry again?";
	static final String NO_SAME_TERRAIN = "\n%s, the domino you have choosen cannot be placed due to no same terrain found! \nSo you keep the score of %d points.\n\nTry again?";
	
	enum MsgType {SUCCESS, DIAGONAL, OCCUPIED, OUTSIDE_FRAME, NO_SAME_TERRAIN};
	
	boolean success = true;
	String msg;
	MsgType type;
	
	Message(Player player, MsgType type, int points){
		this.type = type;
		msg = String.format(getMessageFormat(type), player.name, points);
	}
	
	private String getMessageFormat(MsgType type) {
		success = false;
		switch(type) {
		case SUCCESS:
			success = true;
			return SUCCESS;
		case DIAGONAL:
			return DIAGONAL;
		case OCCUPIED:
			return OCCUPIED;
		case OUTSIDE_FRAME:
			return OUTSIDE_FRAME;
		case NO_SAME_TERRAIN:
			return NO_SAME_TERRAIN;		
		}
		return "";
	}
}

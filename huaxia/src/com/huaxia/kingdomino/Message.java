package com.huaxia.kingdomino;

public class Message {
	static final String SUCCESS = "\n%s, you have score of %d points.";
	static final String DIAGONAL = "\n%s, the domino you have choosen cannot be placed due to diagonal location choosen! So you keep the score of %d points.";
	static final String OCCUPIED= "\n%s, the domino you have choosen cannot be placed due to locations occupied! So you keep the score of %d points.";
	static final String OUTSIDE_FRAME= "\n%s, the domino you have choosen cannot be placed due to out of 5X5 frame! So you keep the score of %d points.";
	static final String NO_SAME_TERRAIN = "\n%s, the domino you have choosen cannot be placed due to no same terrain found! So you keep the score of %d points.";
	
	enum MsgType {SUCCESS, DIAGONAL, OCCUPIED, OUTSIDE_FRAME, NO_SAME_TERRAIN};
	
	boolean success = true;
	String msg;
	
	Message(Player player, MsgType type, int points){
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

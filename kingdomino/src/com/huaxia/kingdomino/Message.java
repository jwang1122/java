package com.huaxia.kingdomino;

public class Message {
	static final String SUCCESS = "\n%s, you have score of %d points.";
	static final String DIAGONAL = "\n%s, the domino you have choosen cannot be placed due to diagonal location choosen!";
	static final String OCCUPIED= "\n%s, the domino you have choosen cannot be placed due to locations occupied!";
	static final String OUTSIDE_FRAME= "\n%s, the domino you have choosen cannot be placed due to out of 5X5 frame! \nSo you keep the score of %d points.\nTry again?";
	static final String NO_SAME_TERRAIN = "\n%s, the domino you have choosen cannot be placed due to no same terrain found! \nSo you keep the score of %d points.\n\nTry again?";
	static final String PLAYER_RESULT = "\n%s gets a score of %d points!\n\nIts most extensive property is %d!\nFinally he owns a total of %d Crowns!";
	static final String WINNER_RESULT = "The big winner is %s!\n\nHe gets a score of %d points!\nIts most extensive property is %d!\nFinally he owns a total of %d crowns!";
	static final String GAME_OVER = "Game Over!!! Big Winner is %s.";
	
	enum MsgType {SUCCESS, DIAGONAL, OCCUPIED, OUTSIDE_FRAME, NO_SAME_TERRAIN, PLAYER_RESULT, WINNER_RESULT, GAME_OVER};
	
	boolean success = true;
	String msg;
	MsgType type;
	
	Message(MsgType type, Player winner){
		this.type = type;
		msg = String.format(getMessageFormat(type), winner.getName());
	}
	
	Message(Player player, MsgType type, int points){
		this.type = type;
		msg = String.format(getMessageFormat(type), player.name, points);
	}
	
	public Message(Player player, MsgType playerResult, int score, int maxField, int crowns) {
		this.type = playerResult;
		msg = String.format(getMessageFormat(playerResult), player.name, score, maxField, crowns);
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
		case PLAYER_RESULT:
			return PLAYER_RESULT;
		case WINNER_RESULT:
			return WINNER_RESULT;
		case GAME_OVER:
			return GAME_OVER;
		}
		return "";
	}
}

package fiveinline;

public class Chess {
	public static final int SIZE = 30;
	public int i, j; // indexes
	public int x, y; // coordinates
	public enum Property {BLACK, WHITE, NONE};
	public Property prop = Property.NONE;
	
	public Chess(int i, int j) {
		this.i = i;
		this.j = j;
		x = (i+1) * SIZE;
		y = (j+1) * SIZE;		
	}
}

package game2D;

public class Size {
	public int width;
	public int height;
	
	public Size(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	@Override
	public String toString() {
		return String.format("(%dx%d)", width, height);
	}

}

package snake;

public class Size {
	int width;
	int height;
	
	Size(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	@Override
	public String toString() {
		return String.format("(%dx%d)", width, height);
	}

}

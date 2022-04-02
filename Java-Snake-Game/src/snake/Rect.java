package snake;

public class Rect {
	int left;
	int top;
	int width;
	int height;
	int right;
	int bottom;
	Position topleft;
	Position topright;
	Position bottomleft;
	Position bottomright;
	
	public Rect(int left, int top, int width, int height){
		this.left = left;
		this.top = top;
		this.width = width;
		this.height = height;
		right = left + width;
		bottom = top + height;
		topleft = new Position(left, top);
		topright = new Position(right, top);
		bottomleft = new Position(left, bottom);
		bottomright = new Position(right, bottom);
	}
	
	public boolean colliderect(Rect rect) {
		boolean flag1 = collidepoint(rect.topleft) || collidepoint(rect.topright) || collidepoint(rect.bottomright) || collidepoint(rect.bottomright);
		boolean flag2 = rect.collidepoint(this.topleft) || rect.collidepoint(this.topright) || rect.collidepoint(this.bottomright) || rect.collidepoint(this.bottomright);
		return flag1 || flag2;
	}
	
	public boolean collidepoint(Position position) {
//		boolean flag = false;
//		flag = position.x >= left && position.x <= right && position.y>=top && position.y<=bottom;
//		return flag;
		return position.x >= left && position.x <= right && position.y>=top && position.y<=bottom;
	}
}

package game2D;

public class Rect {
	public int left, top, width, height, right, bottom;
	public Position topleft, topright, bottomleft, bottomright;

	public Rect(int left, int top, int width, int height) {
		this.left = left;
		this.top = top;
		this.width = width;
		this.height = height;
		updateValues();
	}

	public Rect(Position pos, Size size) {
		this.left = pos.x;
		this.top = pos.y;
		this.width = size.width;
		this.height = size.height;
		updateValues();
	}

	public void updateValues() {
		right = left + width;
		bottom = top + height;
		topleft = new Position(left, top);
		topright = new Position(right, top);
		bottomleft = new Position(left, bottom);
		bottomright = new Position(right, bottom);
	}

	public boolean colliderect(Rect rect) {
		boolean flag1 = collidepoint(rect.topleft) || collidepoint(rect.topright) || collidepoint(rect.bottomright)
				|| collidepoint(rect.bottomright);
		boolean flag2 = rect.collidepoint(this.topleft) || rect.collidepoint(this.topright)
				|| rect.collidepoint(this.bottomright) || rect.collidepoint(this.bottomright);
		return flag1 || flag2;
	}

	public boolean collidepoint(Position position) {
		return position.x >= left && position.x <= right && position.y >= top && position.y <= bottom;
	}

	public void move_ip(Size size) {
		this.left += size.width;
		this.top += size.height;
		updateValues();
	}

	public void setTopLeft(Position pos) {
		this.left = pos.x;
		this.top = pos.y;
		updateValues();
	}

	@Override
	public String toString() {
		return "Rect [left=" + left + ", top=" + top + "]";
	}

	public Rect copy() {
		return new Rect(left, top, width, height);
	}
}

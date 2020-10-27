
public class Domino implements Comparable<Domino>{
	
	private int side1, side2;
	
	public Domino() {
		this.side1 = 0;
		this.side2 = 0;
	}
	public Domino(int side1, int side2) {
		this.side1 = side1;
		this.side2 = side2;
	}
	public int getSide1() {
		return side1;
	}
	public int getSide2() {
		return side2;
	}
	public String toString() {
		
		return "["+side1+"|"+side2+"]";
	}
	
	public Domino rotate() {
		int temp = side1;
		side1 = side2;
		side2 = temp;
        return this;
	}

	@Override
	public int compareTo(Domino dom) {
		 int diff;
		 diff=Math.max(side1,side2)-Math.min(dom.getSide1(), dom.getSide2());
		 if(diff!=0)
			 return diff;
		return Math.min(side1, side2)-Math.min(dom.getSide1(), dom.getSide2());
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + side1;
		result = prime * result + side2;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Domino other = (Domino) obj;
		if (side1 != other.side1)
			return false;
		if (side2 != other.side2)
			return false;
		return true;
	}

}

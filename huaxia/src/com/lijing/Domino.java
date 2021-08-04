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
		 if(this.equals(dom)) {
			 return 0;
		 }
		 diff=Math.max(side1,side2)-Math.min(dom.getSide1(), dom.getSide2());
		 if(diff!=0)
			 return diff;
		 diff = Math.min(side1, side2)-Math.max(dom.getSide1(), dom.getSide2());
		 return diff;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Math.min(side1, side2);
		result = prime * result + Math.max(side1, side2);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null) {
			return false;
		}
		if(obj instanceof Domino) {
			Domino d = (Domino)obj;
			return Math.min(side1,side2)==Math.min(d.getSide1(), d.getSide2()) && Math.max(side1,side2)==Math.max(d.getSide1(), d.getSide2());
		}
		return false;
	}

}

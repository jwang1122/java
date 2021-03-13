package com.huaxia.ap2021.section2;

import java.util.ArrayList;
import java.util.List;

public class Experiment {
	/** The mechanical arm used to process the solutions*/
	private MechanicalArm arm;

	/** The list of solutions*/
	private List<Solution> solutions;

	/** Resets the experiment. 
	* Postcondition: The mechanical arm has a current index of 0 
	*                and is facing right. 
	*/
	public void reset() {/* to be implemented in part (a) */
		if (arm.isFacingRight())
			arm.changeDirection();
		arm.moveForward(arm.getCurrentIndex());
		arm.changeDirection();
	}

	/** Finds and returns the index of the most acidic solution
	* ©return index the location of the most acidic solution 
	* or -1 if there are no acidic solutions 
	* Postcondition: The mechanical arm is facing right, and its 
	*                current index is at the most acidic solution, 
	*                or at 0 if there are no acidic solutions. 
	*/
	public int mostAcidic() { /* to be implemented in part (b) */
		reset();
		int minPH = Integer.MAX_VALUE, minlndex = 0;
		int index = 0;
		while (index < solutions.size()) {
			Solution s = solutions.get(index);
			if (s.getPH() < minPH) {
				minPH = s.getPH();
				minlndex = index;
			}
			index++;
		}
		if (minPH >= 7)
			return -1;
		else {
			arm.moveForward(minlndex);
			return minlndex;
		}
	}

	public MechanicalArm getArm() {
		return arm;
	}

	public void setArm(MechanicalArm arm) {
		this.arm = arm;
	}

	public List<Solution> getSolutions() {
		return solutions;
	}

	public void setSolutions(List<Solution> solutions) {
		this.solutions = solutions;
	}

	public String toString() {
		String result = "";
		for(Solution s: solutions) {
			result += s.getPH() + " ";
		}
		result += "\n" + arm.getCurrentIndex() + ": ";
		if(arm.isFacingRight()) {
			result += " Facing Right\n";
		}else {
			result += " Facing Left\n";			
		}
		return result;
	}
	
	public void init(int[] ph, MechanicalArm arm) {
		List<Solution> solutions = new ArrayList<Solution>();
		for(int i: ph) {
			Solution s = new MySolution();
			s.setPH(i);
			solutions.add(s);
		}
		setSolutions(solutions);
		setArm(arm);
	}
	
	public static void main(String[] args) {
		int[] ph = { 7, 4, 10, 5, 6, 7, 13 };
		Experiment exp=new Experiment();
		MechanicalArm arm = new MyArm(4, false);
		exp.init(ph, arm);
		System.out.println(exp);
		
		exp.reset();
		System.out.println(exp);	
		
		exp.mostAcidic();
		int result = exp.mostAcidic();
		System.out.println(result);
		System.out.println(exp);	

		ph = new int[]{ 7, 9, 8, 8, 12, 13, 14 };
		arm = new MyArm(1, true);
		exp.init(ph, arm);
		result = exp.mostAcidic();
		System.out.println(result);
		System.out.println(exp);	
		
	}

}

class MySolution implements Solution {
	private int ph;

	@Override
	public int getPH() {
		// TODO Auto-generated method stub
		return ph;
	}

	@Override
	public void setPH(int ph) {
		this.ph = ph;
		
	}
}

class MyArm implements MechanicalArm{
	private int index;
	private boolean facingRight = false;

	public MyArm(int currentIndex, boolean facingRight) {
		index = currentIndex;
		this.facingRight = facingRight;
	}
	
	@Override
	public int getCurrentIndex() {
		// TODO Auto-generated method stub
		return index;
	}

	@Override
	public boolean isFacingRight() {
		return facingRight;
	}

	@Override
	public void changeDirection() {
		facingRight = !facingRight;	
	}

	@Override
	public void moveForward(int numLocs) {
		if (facingRight) {
			for(int i=0; i<numLocs; i++)
				index++;		
		}else {
			for(int i=numLocs; i>0; i--)
				index--;		
			
		}
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setFacingRight(boolean facingRight) {
		this.facingRight = facingRight;
	}

}

package com.huaxia.ap2021.section2;

/**
 * Refer to C:\Users\12818\workspace\apcomputer\exams\sectionII-01.md
 * 
 * @see Experiment (
 * @see Solution
 * 
 * @author John
 *
 */
public interface MechanicalArm {
    /** 
     * @return the index of the current location of the mechanical arm 
    * */ 
	int getCurrentIndex();
    
    /** @return true if the mechanical arm is facing right 
    * (toward solutions with larger indexes), 
    * false if the mechanical arm is facing left 
    * (toward solutions with smaller indexes) 
    */
    boolean isFacingRight();
    
    /** Changes the current direction of the mechanicalarm */ 
    void changeDirection();

    /** Moves the mechanical arm forward in its current direction 
    * by the number of locations specified. 
    * @param numLocs the number of locations to move 
    * Precondition: numLocs> 0. */ 
    void moveForward(int numLocs);

}

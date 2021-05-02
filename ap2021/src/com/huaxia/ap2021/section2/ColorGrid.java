package com.huaxia.ap2021.section2;

/**
 * @Refer C:\Users\12818\workspace\apcomputer\exams\sectionII-09.md
 * 
 * Create recursion method to solve this kind problem.
 * 
 *
 */
public class ColorGrid {
	private String[][] myPixels;
	private int myRows;
	private int myCols;

	/**
	 * Creates numRows x numCols ColorGrid from String s.   
	 * @param s the string containing colors of the ColorGrid 
	 * @param numRows the number of rows in the ColorGrid 
	 * @param numCols the number of columns in the ColorGrid 
	 */
	public ColorGrid(String s, int numRows, int numCols) {
		/* to be implemented in part (a) */
		myRows = numRows;
		myCols = numCols;
		myPixels = new String[numRows][numCols];
//		int stringIndex = 0;
//		for (int r = 0; r < numRows; r++)
//			for (int c = 0; c < numCols; c++) {
//				String tmp = s.substring(stringIndex, stringIndex + 1);
//				myPixels[r][c] = tmp;
//				stringIndex++;
//			}
		for(int x=0; x<s.length(); x++) {
			myPixels[x/numCols][x%numCols] = s.substring(x, x+1);
		}
	}

	/**
	 * Precondition: myPixels[row][col] is oldColor, one of "r",
	 *               "b", "g", or "y".
	 *               newColor is one of "r", "b", "g", or "y"
	 * Postcondition: if 0 <= row < myRows and 0 <= col < myCols,
	 *               paints the connected region of
	 *               myPixels[row][col] the newColor.
	 *               Does nothing if oldColor is the same as 
	 *               newColor.
	 * @param row the given row
	 * @param col the given column  
	 * @param newColor the new color for painting 
	 * @param oldColor the current color of myPixels[row][col] 
	 */
	public void paintRegion(int row, int col, String newColor, String oldColor) {
		/* to be implemented in part (b) */
		if (row >= 0 && row < myRows && col >= 0 && col < myCols)
			if (!myPixels[row][col].equals(newColor) && myPixels[row][col].equals(oldColor)) {
				myPixels[row][col] = newColor;
				paintRegion(row + 1, col, newColor, oldColor);
				paintRegion(row - 1, col, newColor, oldColor);
				paintRegion(row, col + 1, newColor, oldColor);
				paintRegion(row, col - 1, newColor, oldColor);
			}
	}

	// other methods not shown
	public String toString() {
		String result="";
		for (int r = 0; r < myRows; r++) {
			for (int c = 0; c < myCols; c++) {
				result += myPixels[r][c] + " ";
			}
			result +="\n";
		}
		return result;
	}

	public static void main(String[] args) {
		ColorGrid grid = new ColorGrid("brrygrggyyyr", 3, 4);
		System.out.println(grid);
		
		grid = new ColorGrid("rrbgyybrbyrrggrrrbyrryrb", 4, 6);
		System.out.println("before: ");
		System.out.println(grid);
		
		System.out.println("\nafter: ");
		grid.paintRegion(2, 3, "b", "r");
		System.out.println(grid);
	}
}
/*
 * NOTE 
 * In part (a), you don’t need to test if stringindex is in range: The precondition states that the number of characters in s is numRows x numCols.
 * 
 * 
 */

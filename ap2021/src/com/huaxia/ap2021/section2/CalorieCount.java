package com.huaxia.ap2021.section2;

public class CalorieCount {
	private int numCaloriesLimit;
	private int numCaloriesIntake;
	private int gramsProtein;
	int gramsCarbohydrate;
	int gramsFat;

	public CalorieCount(int numCal) {
		numCaloriesLimit = numCal;
		numCaloriesIntake = 0;
		gramsProtein = 0;
		gramsCarbohydrate = 0;
		gramsFat = 0;
	}

	public void addMeal(int calories, int protein, int carbs, int fat) {
		numCaloriesIntake += calories;
		gramsProtein += protein;
		gramsCarbohydrate += carbs;
		gramsFat += fat;
	}

	public double getProteinPercentage() {
		return 4.0 * gramsProtein / numCaloriesIntake;
	}

	public boolean onTrack() {
		return numCaloriesIntake <= numCaloriesLimit;
	}

	public static void main(String[] args) {
		CalorieCount sunday= new CalorieCount(1500);
		sunday.addMeal(716,38,38,45);
		sunday.addMeal(230,16,8,16);
		sunday.addMeal(568,38,50,24);
		sunday.onTrack();
		double percentage = sunday.getProteinPercentage();
		System.out.println(percentage);
	}

}

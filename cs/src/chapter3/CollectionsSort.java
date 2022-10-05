package chapter3;

import java.util.Arrays;
import java.util.Collections;

public class CollectionsSort {

	public static void main(String[] args) {
		Integer arr[] = { 3, 60, 35, 2, 45, 320, 5 };		
		Collections.sort(Arrays.asList(arr));
		System.out.println(Arrays.toString(arr));
	}

}

package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopyOver {

	public static void main(String[] args) {
//		int[] arr = {0,24,16,0,36,42,23,21,0,27};
		int[] arr = {2,0,4,1};
		List<Integer> list = new ArrayList<>();
		int count = 0;
		for(int i:arr) {
			if(i!=0) {
				count++;
				list.add(i);
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(list);
		System.out.println(count);
	}

}

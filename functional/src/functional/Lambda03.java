package functional;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambda03 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10,2,1,11,12,4,45);
		Collections.sort(list);
		Collections.sort(list, new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1<o2) return -1;
				if(o1>o2) return 1;
				return 0;
			}
			
		});
		System.out.println(list);
	}

}

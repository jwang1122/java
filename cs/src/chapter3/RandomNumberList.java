package chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberList {
	static List<Long> list = new ArrayList<>();
	
	public static List<Long> getRandomList(long n){
		for(long i=1; i<=n; i++) {
			list.add(i);
		}
		Collections.shuffle(list);
		return list;
	}
}

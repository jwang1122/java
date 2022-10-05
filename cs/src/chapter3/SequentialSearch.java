package chapter3;

import java.util.List;

public class SequentialSearch {
	public static Long find(Long n, List<Long> list) throws NotFoundException{
		long count = 0;
		for(Long l: list) {
			count++;
			if(l.equals(n)) {
				System.out.printf("compare %s times.\n", count);
				return l;
			}
		}
		throw new NotFoundException("The number not found.");
	}
	
	public static void main(String[] args) throws Exception{
		List<Long> list = RandomNumberList.getRandomList(10000L);
		System.out.println(list.size());
		Long l = find(10000L, list);
		System.out.println(l);
	}

}

class NotFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public NotFoundException(String msg) {
		super(msg);
	}
}

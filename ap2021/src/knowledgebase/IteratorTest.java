package knowledgebase;

public class IteratorTest {

	public static void main(String[] args) {
//		int n = 3; // some integer greater than zero
//		count(n);
//		System.out.println(n*(n-1));
//		while1();
//		forWhile(5);
		printArray();
	}

	private static void forWhile(int someNum) { // all for can be written as while
		int tmp = someNum;
		for (int i = 0; i < someNum; i++) {
			someNum--;
			System.out.println(i);
		}
		System.out.println("someNum: " + someNum);

		someNum = tmp;
		for (int i = 1; i < someNum - 1; i++) {
			someNum -= 1;
			System.out.println(i);
		}
		System.out.println("someNum: " + someNum);

		someNum = tmp;
		int i = 0;
		while (i < someNum) {
			i++;
			someNum--;
		}
		System.out.println(i + "," + someNum);
	}

	static void while1() {
		int val1 = 2, val2 = 22, val3 = 78;
		while (val2 % val1 == 0 || val2 % 3 == 0) {
			val3++;
			val2--;
		}
		System.out.println(val2 + ", " + val3);
	}

	static void count(int n) {
		int count = 0;
		int p = 0;
		int q = 0;
		for (p = 1; p < n; p++)
			for (q = 1; q <= n; q++)
				count++;
		System.out.println(count);

	}

	static void printArray() {
		int[] nums = { 11, 22, 33, 44, 55, 66 };
		for (int i = 0; i < nums.length; i++) {
			nums[nums[i] / 11] = nums[i];
		}
		int i = 0;
		while (i < nums.length) {
			System.out.print(nums[i++]);
			if (i != 0 && i<nums.length)
				System.out.print(", ");
		}
		System.out.println();

	}
}

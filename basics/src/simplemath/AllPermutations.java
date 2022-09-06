package simplemath;

public class AllPermutations {
	static int count = 1;
	public static void getPermutations(int[] array) {
		output(array, 0);
	}

	private static void output(int[] array, int pos) {
		if (pos >= array.length - 1) {
			String s = String.format("%2d: [",count);
			for (int i = 0; i < array.length; i++) {
				s += array[i] + ", ";
			}
			s = s.substring(0, s.length()-2) + "]";
			System.out.println(s);
			count++;
			return;
		}
		
		for (int i = pos; i < array.length; i++) {

			int t = array[pos];
			array[pos] = array[i];
			array[i] = t;

			output(array, pos + 1);

			t = array[pos];
			array[pos] = array[i];
			array[i] = t;
		}
	}

	public static void main(String args[]) {
		int[] numbers = { 1, 9, 4, 3 };
		getPermutations(numbers);
	}
}
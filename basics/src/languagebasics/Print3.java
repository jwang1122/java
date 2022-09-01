package languagebasics;

/*
 * print patterns
 */
public class Print3 {

	public static void main(String[] args) {
		Print3 test = new Print3();
		test.builderTest();
		System.out.println();
		test.bufferTest();
	}
	
	private void builderTest() {
		StringBuilder sb = new StringBuilder();
		sb.append("abcde");
		sb.append("12345");
		System.out.println(sb);
		sb = new StringBuilder("START:");
		sb.append("abcde");
		sb.append("12345");
		System.out.println(sb);
		sb.insert(11, "XXXX");
		System.out.println(sb);
		System.out.println(sb.indexOf("123"));
		System.out.println(sb.lastIndexOf("123"));
		sb.replace(5, 6, "::::");
		System.out.println(sb);
		System.out.println(sb.substring(9));
		System.out.println(sb.substring(9,14));
	}
	
	private void bufferTest() {
		StringBuffer sb = new StringBuffer();
		sb.append("abcde");
		sb.append("12345");
		System.out.println(sb);
		sb = new StringBuffer("START:");
		sb.append("abcde");
		sb.append("12345");
		System.out.println(sb);
		sb.insert(11, "XXXX");
		System.out.println(sb);
		System.out.println(sb.indexOf("123"));
		System.out.println(sb.lastIndexOf("123"));
		sb.replace(5, 6, "::::");
		System.out.println(sb);
		System.out.println(sb.substring(9));
		System.out.println(sb.substring(9,14));
	}
}

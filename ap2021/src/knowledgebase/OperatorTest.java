package knowledgebase;

public class OperatorTest {
	public static void main(String[] args) {
//		reminderTest();
//		getJob();
//		logicTest();
		int vail = 2, val2 = 22, val3 = 78; 
		while (val2 % vail == 0 || val2 % 3 == 0 ){
			val3++; 
			val2--; 
		}
		System.out.println(val3);
	}

	static void getJob() {
		boolean a = true, b = false;
		if (a && !b)
			System.out.println("I. \tNice job.");
		else
			System.out.println("I. \tNicer job.");

		if (!a || b)
			System.out.println("II. \tNice job.");
		else
			System.out.println("II. \tNicer job.");

		if (!a && b)
			System.out.println("III. \tNice job.");
		else
			System.out.println("III. \tNicer job .");

	}

	static void logicTest() {
		getLogic(true, true);
		getLogic(true, false);
		getLogic(false, true);
		getLogic(false, false);
	}

	static void getLogic(boolean p, boolean q) {
		boolean flag = (!p && !q) || !(p || q);
		System.out.println(flag);
	}

	static void reminderTest() {
		getReminder(0, 50);
		getReminder(10, 50);
		getReminder(25, 50);
		getReminder(40, 50);
		getReminder(50, 50);
	}

	static void getReminder(int i, int x) {
		System.out.println(i % x);
	}
}

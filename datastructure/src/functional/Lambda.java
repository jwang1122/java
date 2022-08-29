package functional;

public class Lambda {

	public static void main(String[] args) {
		Sayable s = () -> {
			return "I have nothing to say.";
		};
		System.out.println(s.say());
	}

}

interface Sayable {
	public String say();
}
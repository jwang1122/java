package functional;

public class PassFunction {

	public static void invoke(Callable callable, int param) {
		callable.call(param);
	}
	
	public static void main(String[] args) {
		Callable add100 = new Add100();
		invoke(add100, 33);
	}
}

interface Callable {
    public void call(int param);
}
    
class Add100 implements Callable {
    public void call(int param) {
    	int result = 100 + param;
        System.out.println( result );
    }
}
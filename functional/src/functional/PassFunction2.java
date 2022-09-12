package functional;

import java.lang.reflect.Method;

public class PassFunction2 {

	public int functionToPass(String message) {
		return message.length();
	}

	public void outerFunction(Object object, Method method, String message) throws Exception {
		Object[] parameters = new Object[1];
		parameters[0] = message;
		System.out.println(method.invoke(object, parameters));
	}

	public static void main(String[] args) throws Exception {
		Class<?>[] parameterTypes = new Class[1];
		parameterTypes[0] = String.class;
		Method functionToPass = PassFunction2.class.getMethod("functionToPass", parameterTypes[0]);
		PassFunction2 main = new PassFunction2();
		main.outerFunction(main, functionToPass, "This is the input");
	}
}

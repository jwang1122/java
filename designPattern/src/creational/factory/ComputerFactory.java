package creational.factory;

import java.lang.reflect.Constructor;

public class ComputerFactory {
	public static Computer getComputer(String type, String ram, String hdd, String cpu) {
		if ("PC".equalsIgnoreCase(type))
			return new PC(ram, hdd, cpu);
		else if ("Server".equalsIgnoreCase(type))
			return new Server(ram, hdd, cpu);

		return null;
	}

	public static Computer getComputer(String className) {
		Computer computer = null;
		try {
//			computer = (Computer)Class.forName(className).newInstance();
			Constructor<?>[] ctors = Class.forName(className).getDeclaredConstructors();
			Constructor<?> ctor = null;
			for (int i = 0; i < ctors.length; i++) {
				ctor = ctors[i];
				if (ctor.getGenericParameterTypes().length == 0)
					break;
			}
			computer = (Computer)ctor.newInstance();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return computer;
	}


}

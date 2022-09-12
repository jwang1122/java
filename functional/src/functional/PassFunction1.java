package functional;

import java.lang.reflect.Method;

public class PassFunction1 {

    public void functionToPass(String message) {
        String [] split = message.split(" ");
        for (int i=0; i<split.length; i++)
            System.out.println(split[i]);
    }
    
    public void outerFunction(Object object, Method method, String message) throws Exception {
        Object[] parameters = new Object[1];
        parameters[0] = message;
        method.invoke(object, parameters);
    }

    public static void main(String[] args) throws Exception{
        Class<?>[] parameterTypes = new Class[1];
        parameterTypes[0] = String.class;
        Method functionToPass = PassFunction1.class.getMethod("functionToPass", parameterTypes[0]);
        PassFunction1 main = new PassFunction1();
        main.outerFunction(main, functionToPass, "This is the input");
    }
}

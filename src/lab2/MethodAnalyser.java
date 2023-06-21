package lab2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.InvalidParameterException;

public class MethodAnalyser {
    private static final String DEFAULT_NAME = "PAVEL";
    private static final int DEFAULT_AGE = 15;

    public void analyse(final Object object) {
        if (object == null) {
            return;
        }
        Class<?> clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            Object[] customParametersValues = getParameterValues(method.getParameterTypes());
            MethodAnnotation annotation = method.getAnnotation(MethodAnnotation.class);
            System.out.println("METHOD NAME Is: " + method.getName());
            if (annotation == null) {
                continue;
            }
            boolean isNotAccessible = shouldChangeAccessible(method);
            try {
                if (isNotAccessible) {
                    method.setAccessible(true);
                }
                for (int i = 0; i < annotation.count(); i++) {
                    method.invoke(object, customParametersValues);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            } finally {
                if (isNotAccessible) {
                    method.setAccessible(false);
                }
            }
        }
    }

    private static Object[] getParameterValues(Class<?>[] params) {
        Object[] values = null;
        if (params.length != 0) {
            values = new Object[params.length];
            for (int i = 0; i < params.length; i++) {
                if (params[i] == String.class) {
                    values[i] = DEFAULT_NAME;
                } else if (params[i] == int.class) {
                    values[i] = DEFAULT_AGE;
                } else {
                    throw new InvalidParameterException();
                }
            }
        }
        return values;
    }

    private static boolean shouldChangeAccessible(Method field) {
        return !Modifier.isPublic(field.getModifiers());
    }
}
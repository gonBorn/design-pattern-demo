package singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PreventFromReflectSingleton {
    private PreventFromReflectSingleton() {
        if (LazyHolder.LAZY != null) {
            throw new RuntimeException("creating multiple instances is forbidden");
        }
    }

    public static PreventFromReflectSingleton getInstance() {
        return LazyHolder.LAZY;
    }

    private static class LazyHolder {
        private static final PreventFromReflectSingleton LAZY= new PreventFromReflectSingleton();
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<PreventFromReflectSingleton> constructor = PreventFromReflectSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        PreventFromReflectSingleton instance1 = constructor.newInstance();
        System.out.println(instance1);

        PreventFromReflectSingleton instance2 = constructor.newInstance();
        System.out.println(instance2);
    }
}

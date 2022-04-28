package singleton;

public class InnerClassLazySingleton {
    private InnerClassLazySingleton() {
    }

    public static InnerClassLazySingleton getInstance() {
        return LazyHolder.LAZY;
    }

    private static class LazyHolder {
        private static final InnerClassLazySingleton LAZY= new InnerClassLazySingleton();
    }
}

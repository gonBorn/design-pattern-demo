package singleton;

public class DoubleCheckedLockingLazySingleton {
    private DoubleCheckedLockingLazySingleton() {
    }

    private static volatile DoubleCheckedLockingLazySingleton lazy;

    public static DoubleCheckedLockingLazySingleton getInstance() {
        if (lazy == null) {
            synchronized (DoubleCheckedLockingLazySingleton.class) {
                if (lazy == null) {
                    lazy = new DoubleCheckedLockingLazySingleton();
                }
            }
        }
        return lazy;
    }
}

package singleton;

/**
 * advantage: there is no concurrency problem, no thread safety problem
 * disadvantage: no matter whether you use this object or not,
 * it will be initialized when JVM loading this class, and it will take up space until the program stops.
 */
public class HungrySingleton {
    private HungrySingleton() {
    }

    // this object will be initialized when the class is loaded
    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }
}

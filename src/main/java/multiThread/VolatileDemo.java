package multiThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileDemo {
    public final static int MAX = 5;
//    public static int initValue = 0;
    public static volatile int initValue = 0;

    /**
     *
     *     Note that ++i is not an atomic operation, it contains get, plus, save 3 operations
     *     we can use AtomicInteger#addAndGet()
     *
     */


    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = initValue;
            while (localValue < MAX) {
//                System.out.println("### reader is working");
                if (localValue != initValue) {
                    System.out.println("initValue is updated to " + initValue);
                    localValue = initValue;
                }
            }
        }, "reader").start();

        new Thread(() -> {
            int localValue = initValue;
            while (localValue < MAX) {
                System.out.println(("initValue will be updated to " + ++localValue));
                initValue = localValue;
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "writer").start();
    }
}

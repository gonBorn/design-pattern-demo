package singleton;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SynchronizedLazySingleton {
    private SynchronizedLazySingleton() {
    }

    private static SynchronizedLazySingleton lazy;

    /**
     * when thread1 is executing getInstance(), thread2 comes and also want to execute this method
     * thread2 will be blocked here until thread1 finishes executing
     */

    public synchronized static SynchronizedLazySingleton getInstance() {
        if (lazy == null) {
            lazy = new SynchronizedLazySingleton();
        }
        return lazy;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(11);

        for (int j = 0; j < 10000; j++) {
            final int loop = j;

            // reset our LazySingleton instance to null when starting a new loop
            SynchronizedLazySingleton.lazy = null;

            // use 10 threads to get LazySingleton instance to see in multi-thread situation we may get two LazySingleton instance
            // which is not what we expected
            IntStream.range(0, 10)
                    .boxed()
                    .map(i -> CompletableFuture.supplyAsync(SynchronizedLazySingleton::getInstance, executorService))
                    // it is important to end our stream by collect it to list
                    .collect(Collectors.toList())
                    .stream()
                    .map(CompletableFuture::join)
                    .reduce((x, y) -> {
                        if (x != y) {
                            throw new RuntimeException("We got two objects of class LazySingleton in loop " + loop);
                        } else {
                            return x;
                        }
                    }).get();
        }

    }
}

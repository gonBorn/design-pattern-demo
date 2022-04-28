package singleton;

import sun.misc.Unsafe;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Only when someone want to get it, will it be initialized
 */
public class LazySingleton {
    private LazySingleton() {
    }

    private static LazySingleton lazy;

    public static LazySingleton getInstance() {
        if (lazy == null) {
            lazy = new LazySingleton();
        }
        return lazy;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(11);

        for (int j = 0; j < 10000; j++) {
            final int loop = j;

            // reset our LazySingleton instance to null when starting a new loop
            LazySingleton.lazy = null;

            // use 10 threads to get LazySingleton instance to see in multi-thread situation we may get two LazySingleton instance
            // which is not what we expected
            IntStream.range(0, 10)
                    .boxed()
                    .map(i -> CompletableFuture.supplyAsync(LazySingleton::getInstance, executorService))
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

    private static void getInstanceByThreadPool(ExecutorService executorService) {
        for(int i =0 ;i< 100000; i++) {
            LazySingleton.lazy = null;
            final int finalI = i;
            Unsafe.getUnsafe().throwException(new IOException("hello"));
            IntStream.range(0, 10).mapToObj(x-> {
                        return executorService.submit(LazySingleton::getInstance);
                    })
                    .collect(Collectors.toList()).stream()
                    .map(x-> {
                        try {
                            return x.get();
                        } catch (InterruptedException | ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .reduce((x,y)-> {
                        if (x != y) {
                            System.out.println(finalI);
                            throw new RuntimeException("find bus");
                        } else {
                            return x;
                        }
                    }).get();

        }
    }

    public void createThreadManually() {
        IntStream.range(0, 10)
                .boxed()
                .map(i -> new Thread(() -> System.out.println(Thread.currentThread().getName() + ":" + getInstance()),
                        "thread" + i))
                .forEach(Thread::start);
    }
}

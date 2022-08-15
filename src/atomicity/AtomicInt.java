package atomicity;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicInt {

    private static AtomicInteger a = new AtomicInteger(10);


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<String> result1 = executorService.submit(() -> {
            for(int i=0; i<10; i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int currentVal = a.incrementAndGet();
                System.out.println("Thread 1 incremented value " + currentVal);
            }
        }, "1 Completed");


        Future<String> result2 = executorService.submit(() -> {
            for(int i=0; i<10; i++){
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int currentVal = a.incrementAndGet();
                System.out.println("Thread 2 incremented value " + currentVal);
            }
        }, "2 Completed");


        System.out.println("First thread : " + result1.get());
        System.out.println("Second thread : " + result2.get());
        System.out.println("Atomic Integer Value : " + a);
        executorService.shutdown();
    }


}

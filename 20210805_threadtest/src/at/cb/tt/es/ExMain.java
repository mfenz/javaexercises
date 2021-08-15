package at.cb.tt.es;

import java.util.concurrent.*;

public class ExMain {
    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//        es.submit(new Callable<Object>() {
//        })

//        ExecutorService es = Executors.newCachedThreadPool();
        Future<Integer> future = es.submit(new AddiererCallable(1, 5));
        try {
            Integer integer = future.get();
            System.out.println(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

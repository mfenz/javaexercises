package com.itkurse.factorial;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FactorialMain {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            FactorialCalculator calculator = new FactorialCalculator(i);
            Future<Integer> result = executor.submit(calculator);
            resultList.add(result);
        }

        int completedTasks = 0;
        do {


            completedTasks = 0;
            for (Future<Integer> result : resultList) {
                if (result.isDone()) {
                    completedTasks++;

                    try {
                        System.out.println(result.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }

            System.out.printf("Main: Number of Completed Tasks: %d\n",
                    completedTasks);

            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (completedTasks != resultList.size());

        executor.shutdown();
    }
}

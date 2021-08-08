package at.cb.tt;

import java.util.ArrayList;
import java.util.List;

public class ThreadIncrement {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            threads.add(new Thread(new Addierer()));
        }
        for(Thread thread : threads){
            thread.start();
        }
        for(Thread thread : threads){
            thread.join();
        }
        System.out.printf("Counter: %d %n", counter);
    }

    private static class Addierer implements Runnable {
        @Override
        public void run() {
            for(int i = 0; i < 1_000_000; i++){
                //ThreadIncrement.counter++;
                plusOne();
            }
        }
    }

    private synchronized static void plusOne(){
        counter++;
    }

    private static int counter;


}

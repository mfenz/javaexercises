package at.cb.asyncservice;

import java.util.concurrent.ForkJoinPool;

public class ThTest {
    public static void main(String[] args) {
        new Thread(() -> {
            for(int i = 0; i < 20; i++){
                System.out.printf("a %d %n", i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for(int i = 0; i < 20; i++){
                System.out.printf("b %d %n", i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("MAIN THREAD END");
    }
}

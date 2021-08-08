package at.cb.tt;

public class ThreadManagement {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
            }
        });

        thread.start();


        thread.join();


        System.out.println("Main-Thread ist nun fertig.");
    }
}

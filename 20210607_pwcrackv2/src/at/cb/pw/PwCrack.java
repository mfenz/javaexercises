package at.cb.pw;

public class PwCrack {

    private static String passwort = "123456";
    private static int counter = 0;
    private static boolean success = false;
    private static int length = 0;

    private static void zeichen(String thisString, int thisDepth, int maxDepth) {

        if(thisDepth == maxDepth){
            return;
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        char x = 33;
        while (x < 127){
            String s = thisString + x;
            //System.out.printf("Versuch %d: %s%n", counter, s);
            if(counter % 100000 == 0){
                System.out.printf("Versuch %d: %s%n", counter, s);
            }
            if(s.equals(passwort)){
                System.out.println("Passwort gefunden! " + s);
                System.exit(0);
            }
            int td = thisDepth + 1;

            // GUT:
            // zeichen(s, td, maxDepth);

            // Killer:
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    zeichen(s, td, maxDepth);
                }
            });
            t.start();



            x++;

            counter++;
        }
    }


    private synchronized static void start(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(!success){
                    length++;
                    zeichen("", 0, length);
                }
            }
        });
        t.start();
    }

    public static void main(String[] args) throws InterruptedException {


        start();
        start();
        start();
        start();
        start();
        start();

//        while(!success){
//            System.out.println("Start: " + length);
//            zeichen("", 0, length);
//            length++;
//        }

//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    System.out.println("t1");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        t1.start();
//
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    System.out.println("t2");
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//
//        t2.start();
//        t1.join();
    }
}

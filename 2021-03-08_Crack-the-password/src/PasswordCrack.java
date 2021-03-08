public class PasswordCrack {

    private static String passwort = "123456";
    private static long counter = 0;

    private static void zeichen(String thisString, int thisDepth, int maxDepth) throws InterruptedException {
        if(thisDepth == maxDepth){
            return;
        }
        char x = 33;
        while (x < 127){
            String s = thisString + x;
            //System.out.println(s);
            counter++;
            if(counter % 1000000 == 0){
                System.out.printf("counter=%d\n", counter);
            }
            if(s.equals(passwort)){
                System.out.println("Passwort gefunden! " + s);
                System.exit(0);
            }
//            Thread.sleep(50);
            int td = thisDepth + 1;
            zeichen(s, td, maxDepth);
            x++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int length = 1;
        boolean success = false;
        while(!success){
            zeichen("", 0, length);
            length++;
        }

//        int counter = 0;
//        for(char a = 33; a <= 126; a++){
//            for(char b = 33; b <= 126; b++){
//                for(char c = 33; c <= 126; c++){
//                    for(char d = 33; d <= 126; d++){
//                        String test = "" + a + b + c + d;
//                        //System.out.printf("Probiere ... %s \n", test);
//                        ++counter;
//                        if(test.equals(passwort)){
//                            System.out.printf("Passwort=%s \n", test);
//                            System.out.printf("Counter=%d", counter);
//                            return;
//                        }
//                    }
//                }
//            }
//        }
    }
}

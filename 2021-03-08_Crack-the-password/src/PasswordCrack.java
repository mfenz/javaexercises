public class PasswordCrack {
    public static void main(String[] args) {
        String passwort = "zzzz";

        int length = 1;

        boolean success = false;
        char []chars;
        while(!success){
            chars = new char[length];
            for(int i = 0; i < length; i++){

            }
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

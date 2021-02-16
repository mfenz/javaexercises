public class ContinueVerwenden {
    public static void main(String[] args) {

        String oldString = "abcdefg";
        String result = "";
        for(int i = oldString.length() - 1; i >= 0; i--){
            char zeichen = oldString.charAt(i); //oldString.substring(i, i+1);
            result += zeichen;
        }
        System.out.println(oldString + " umgedreht: " + result);

//        String sub = oldString.substring(0, 2);
//        System.out.println(sub);

//        for(int i = 0; i <= 30; i += 10){
//            if(i == 20){
//                continue;
//            }
//            System.out.printf("i=%d\n", i);
//        }
//        System.out.println("Fertig!");
    }
}

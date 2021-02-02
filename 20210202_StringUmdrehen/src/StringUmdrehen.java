public class StringUmdrehen {
    // Instanzvariable
    private String eingabe;

    public StringUmdrehen(String eingabe){
        this.eingabe = eingabe;
    }
    // abc --> .length() --> 3
    // c --> Index 2

    // abcdefg --> .length() --> 7
    // g --> Index 6
    public String stringUmdrehen(){
        String result = "";
        for(int i = eingabe.length() - 1; i >= 0; --i){
            char x = eingabe.charAt(i);
            result = result + x;

//            System.out.println("i=" + i);
//            System.out.println("x=" + x);
//            System.out.println("result=" + result);
        }
        return result;
    }

    public String getEingabe(){
        return eingabe;
    }
}

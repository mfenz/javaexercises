public class XA {
    public static void main(String[] args) {
        char x = 'a';
        int a = 5;
        x++;
        if(x >= 'b' && x <= 'z'){
            boolean y = a > 5;
            if(x == 'b' && y){
                System.out.println("p");
            } else if(x == 'b' && !y){
                System.out.println("e");
            }
        }
        System.out.println("f");

    }
}

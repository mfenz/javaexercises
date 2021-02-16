import java.util.HashSet;
import java.util.Set;

public class Zahlen {
    public static void main(String[] args) {
        Set<Integer> z = new HashSet<>();
        // Zahlen einfügen
        z.add(5);
        z.add(3);
        // 5 doppelt!
        z.add(5);
        z.add(100);
        System.out.println("Set Inhalt:");
        for(int x : z){
            System.out.println(x);
        }
    }


    int add(int a, int b){
        int c = a + b;
        return c;
    }



    int add(){
        return 0;
    }

}

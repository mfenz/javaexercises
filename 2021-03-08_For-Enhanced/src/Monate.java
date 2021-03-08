import java.util.ArrayList;
import java.util.List;

public class Monate {
    public static void main(String[] args) {
        String[] monate = new String[12];
        int i = 0;
        monate[i++] = "Jänner";
        monate[i++] = "Februar";
        monate[i++] = "März";
        monate[i++] = "April";
        monate[i++] = "Mai";
        monate[i++] = "Juni";
        monate[i++] = "Juli";
        monate[i++] = "August";
        monate[i++] = "September";
        monate[i++] = "Oktober";
        monate[i++] = "November";
        monate[i++] = "Dezember";

        System.out.println("Monate enhanced for:");
        // Enhanced for loop
        for(String m : monate)
        {
            System.out.println(m);
        }

        System.out.println("Monate for:");
        for(i = 0; i < monate.length; ++i){
            System.out.println(monate[i]);
        }


        int x = 5;
        List<Integer> zahlen = new ArrayList<>();
        zahlen.add(x++);
        zahlen.add(x++);
        zahlen.add(x++);
        zahlen.add(x++);
        zahlen.add(x++);
        zahlen.add(x++);
        zahlen.add(x++);
        zahlen.add(x++);

        System.out.println("Zahlen enhanced for:");
        // enhanced for
        for(int y : zahlen){
            System.out.println(y);
        }

        System.out.println("Zahlen for:");
        for(x = 0; x < zahlen.size(); ++x){
            System.out.println(zahlen.get(x));
        }
    }
}

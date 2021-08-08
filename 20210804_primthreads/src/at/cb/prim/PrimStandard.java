package at.cb.prim;

import java.util.ArrayList;
import java.util.List;

public class PrimStandard {
    public static void main(String[] args) {
        int max = 1000000;

        List<Integer> primzahlen = new ArrayList<>();

        for(int zahl = 2; zahl < max; zahl++){
            boolean teilbar = false;
            for(int i = 2; i <= zahl / 2; i++){
                if(zahl % i == 0){
                    teilbar = true;
                    break;
                }
            }
            if(!teilbar){
                primzahlen.add(zahl);
            }
        }

        System.out.println(primzahlen);
    }
}

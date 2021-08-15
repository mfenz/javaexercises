package at.cb.jf.rt;

public class SummeNZahlenIterativ {
    public static void main(String[] args) {
        int max = 10000;
        long sum = 0;
        for(int i = 0; i <= max; i++){
            sum += i;
        }
        System.out.println(sum);
    }
}

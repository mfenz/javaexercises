package at.cb.jf;

public class ArrayBerechnungIterativ {
    public static void main(String[] args) {
        double[] x = new double[500_000_000];
        for(int i = 0; i < x.length; i++){
            x[i] += i +  Math.tan(Math.sqrt(i));
        }
        System.out.println("Berechnung fertig!");
    }
}

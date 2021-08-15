package at.cb.jf.rt;

import java.util.concurrent.RecursiveTask;

public class QuersummeTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 10;
    private String str; // (Teil-) String, z. B. 95823458
    public QuersummeTask(String str) {this.str = str;}
    @Override
    protected Integer compute() {
        if(str.length() <= THRESHOLD){ // direkt lösen
            int sum = 0;
            for(int i = 0; i < str.length(); i++){
                sum += Integer.parseInt(str.substring(i, i+1)); // Char to int
            }
            return sum;
        }
        int mid = str.length() / 2; // Mitte finden um Tasks in 2 Teile aufzuteilen
        QuersummeTask leftTask = new QuersummeTask(str.substring(0, mid));
        leftTask.fork(); // leftTask als async Task starten
        QuersummeTask rightTask = new QuersummeTask(str.substring(mid, str.length()));
        int rResult = rightTask.compute(); // rechten Task berechnen
        int lResult = leftTask.join(); // auf linken Task warten, Ergenis bekommen
        return lResult + rResult; // zusammengesetztes Ergebnis zurückgeben
    }
}

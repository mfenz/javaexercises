package at.cb.jf.rt;

import java.util.concurrent.RecursiveTask;

public class SummeNZahlenAsync extends RecursiveTask<Long> {
    private static final int THRESHOLD = 100;
    private int start, end;
    public SummeNZahlenAsync(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    protected Long compute() {
        if(end - start < THRESHOLD){
            // (Teil-) Ergebnis berechnen
            return performTask();
        }
        // Task weiter aufteilen
        int mid = start + (end - start) / 2;
        SummeNZahlenAsync leftTask = new SummeNZahlenAsync(start, mid);
        // async Ausführen des neuen Tasks im Pool des aktuellen Tasks
        leftTask.fork();

        SummeNZahlenAsync rightTask = new SummeNZahlenAsync(mid + 1, end);
        long rightTaskResult = rightTask.compute();

        long leftTaskResult = leftTask.join();
        return leftTaskResult + rightTaskResult;
    }
    private long performTask(){
        long result = 0;
        for(int i = start; i <= end; i++){
            result += i;
        }
        return result;
    }
}

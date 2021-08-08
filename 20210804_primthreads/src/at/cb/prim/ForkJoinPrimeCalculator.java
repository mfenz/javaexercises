package at.cb.prim;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPrimeCalculator extends RecursiveTask<List<Integer>> {
    public static final int THRESHOLD = 10000;

    private int start;
    private int end;

    public ForkJoinPrimeCalculator(int start, int end) {
//        System.out.printf("start=%10d end=%10d parent=%10d %s %n", start, end, parent, dir);
        this.start = start;
        this.end = end;
    }

    @Override
    protected List<Integer> compute() {

        int length = end - start;
//        System.out.printf("start=%10d end=%10d length=%10d %n", start, end, length);
        if(length <= THRESHOLD){
            return computeSequentially();
        }

        int mid = start + (end - start) / 2;

        ForkJoinPrimeCalculator leftTask = new ForkJoinPrimeCalculator(start, mid);
        leftTask.fork();

        ForkJoinPrimeCalculator rightTask = new ForkJoinPrimeCalculator(mid, end);

//        System.out.printf("Create left with start=%10d end=%10d (start=%10d end=%10d)%n", start, end/2, start, end);
//        ForkJoinPrimeCalculator leftTask = new ForkJoinPrimeCalculator(start, end / 2, "left", parent + 1);
//        leftTask.fork();
//
//        System.out.printf("Create right with start=%10d right=%10d %n", (end / 2), end);
//        ForkJoinPrimeCalculator rightTask = new ForkJoinPrimeCalculator((end / 2), end, "right", parent + 1);
        List<Integer> rightResult = rightTask.compute();

        List<Integer> leftResult = leftTask.join();
        leftResult.addAll(rightResult);


        return leftResult;
    }

    private List<Integer> computeSequentially(){
        List<Integer> primzahlen = new ArrayList<>();

        for(int zahl = start; zahl < end; zahl++){
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

        return primzahlen;
    }
}

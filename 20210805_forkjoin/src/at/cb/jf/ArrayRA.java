package at.cb.jf;

import java.util.concurrent.RecursiveAction;
public class ArrayRA extends RecursiveAction {
    public static final int THRESHOLD = 62_500_000;
    private double[] array;
    private int startIndex, endIndex;
    public ArrayRA(double[] array, int startIndex, int endIndex) {
        this.array = array; this.startIndex = startIndex; this.endIndex = endIndex; }
    @Override
    protected void compute() {
        int length = endIndex - startIndex;
        if(length <= THRESHOLD){
            // Problem direkt lösen
            for(int i = startIndex; i <= endIndex; i++){
                array[i] += i +  Math.tan(Math.sqrt(i));
            }
        } else {
            int mid = startIndex + (endIndex - startIndex) / 2;
            // In linken Teiltask aufteilen
            ArrayRA leftTask = new ArrayRA(array, startIndex, mid);
            leftTask.fork();
            // In rechten Teiltask aufteilen
            ArrayRA rightTask = new ArrayRA(array, mid, endIndex);
            rightTask.compute();
            leftTask.join();
        }
    }
}

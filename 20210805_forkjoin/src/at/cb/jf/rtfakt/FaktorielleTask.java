package at.cb.jf.rtfakt;

import java.math.BigInteger;
import java.util.concurrent.RecursiveTask;

public class FaktorielleTask extends RecursiveTask<BigInteger> {

    private static final int THRESHOLD = 5;

    private int start, end;

    public FaktorielleTask(int start, int end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected BigInteger compute() {
        if(end - start <= THRESHOLD){
            return sumFactorials();
        }
        int mid = start + (end - start) / 2;
        FaktorielleTask left = new FaktorielleTask(start, mid);
        left.fork();

        FaktorielleTask right = new FaktorielleTask(mid + 1, end);
        BigInteger rightResult = right.compute();
        BigInteger leftResult = left.join();
        return leftResult.multiply(rightResult);
    }

    private BigInteger sumFactorials(){
        BigInteger sum;
        if(start == 0){
            sum = BigInteger.ONE;
        } else {
            sum = BigInteger.valueOf(start);
        }
        for(int i = start + 1; i <= end; i++){
            sum = sum.multiply(BigInteger.valueOf(i));
        }
        return sum;
    }
}

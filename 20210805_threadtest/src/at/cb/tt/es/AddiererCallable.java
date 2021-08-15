package at.cb.tt.es;

import java.util.concurrent.Callable;

public class AddiererCallable implements Callable<Integer> {
    private int a, b;

    public AddiererCallable(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer call() throws Exception {
        return a+b;
    }
}

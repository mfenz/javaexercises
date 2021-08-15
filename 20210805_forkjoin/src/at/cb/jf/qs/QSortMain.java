package at.cb.jf.qs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class QSortMain {
    public static void main(String[] args) {
        List<Integer> input = List.of(7, 3, 5, 5, 2, 56, 7, 3, 56, 8533, 34,
                54, 345, 7, 345, 53, 2, 5, 77);

        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        List<Integer> result = forkJoinPool.invoke(new QSortRT(input));

        System.out.println(result);

        ArrayList<Integer> l = new ArrayList<>(input);
        Collections.sort(l);
        System.out.println(l);
    }
}

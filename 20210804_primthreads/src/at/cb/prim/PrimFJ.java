package at.cb.prim;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class PrimFJ {
    public static void main(String[] args) {
        ForkJoinPrimeCalculator forkJoinPrimeCalculator =
                new ForkJoinPrimeCalculator(
                2, 1000000);
//        forkJoinPrimeCalculator.fork();
        List<Integer> invoke = new ForkJoinPool().invoke(
                forkJoinPrimeCalculator);
        System.out.println(invoke);

        List<CompletableFuture<String>> futures = invoke.stream()
                .map(primzahl -> CompletableFuture.supplyAsync(() -> {
                    return String.format("Primzahl: %d", primzahl);
                })).collect(Collectors.toList());
        List<String> collect = futures.stream().map(CompletableFuture::join)
                .collect(Collectors.toList()); // Buch 398!!
    }
}

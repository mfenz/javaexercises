package at.cb.minmax.operations;

import java.util.List;
import java.util.Random;

public class MinMaxBetrunken implements MinMaxFinder{
    @Override
    public int findMin(List<Integer> values) {
        Random random = new Random();
        return values.get(random.nextInt(values.size() - 1));
    }

    @Override
    public int findMax(List<Integer> values) {
        return 0;
    }
}

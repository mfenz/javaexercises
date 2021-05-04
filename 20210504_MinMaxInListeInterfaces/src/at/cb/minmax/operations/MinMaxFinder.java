package at.cb.minmax.operations;

import java.util.List;

// Interfaces geben nur das Verhalten vor, ohne konkreter Implementierung
public interface MinMaxFinder {
    int findMin(List<Integer> values);
    int findMax(List<Integer> values);
}

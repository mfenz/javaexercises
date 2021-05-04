package at.cb.minmax.operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Liefert das größte und kleinste Element einer Liste mit Hilfe der
 * Sortier-Funktionen von Listen
 */
public class MinMaxWithListSort implements MinMaxFinder{
    @Override
    public int findMin(List<Integer> values) {
        // Kopie der Liste anfertigen
        List<Integer> list = new ArrayList<>(values);

        // Liste sortieren
        list.sort((o1, o2) -> Integer.compare(o1, o2));

        return list.get(0);
    }

    @Override
    public int findMax(List<Integer> values) {
        // Kopie der Liste erstellen
        List<Integer> list = new ArrayList<>(values);
        // Sortieren
        Collections.sort(list, Collections.reverseOrder());

        return list.get(0);
    }
}

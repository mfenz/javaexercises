import io.FileUtils;
import model.Entry;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// data: https://www.data.gv.at/katalog/dataset/d3b85461-fc0d-3639-9aa9-39211c4ecade
public class Calculator {
    public static void main(String[] args) {
        // Key: year, Value: deaths
        Map<Integer, Integer> perYear = new HashMap<>();
        try {
            // Daten aus Datei laden
            List<Entry> entries = FileUtils.fromUrl(new URL("https://data.statistik.gv" +
                    ".at/data/OGD_gest_kalwo_GEST_KALWOCHE_100.csv"));
            // Jede "Zeile" zu Map hinzufügen
            for (Entry entry : entries) {
                // Aktuellen Wert aus Map für Jahr holen (oder 0)
                int deathsInYear = perYear.getOrDefault(entry.getYear(), 0);
                // Entry dazurechnen
                deathsInYear += entry.getDeaths();
                // neuen Wert für Jahr in Map setzen
                perYear.put(entry.getYear(), deathsInYear);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        perYear.forEach((year, deaths) -> {
            System.out.printf("Year %d: %d\n", year, deaths);
        });
    }

//    public static void mains(String[] args) {
//        // Map<Jahr, Map<Kalenderwoche, deaths>>
//        Map<Integer, Map<Integer, Integer>> perYear = new HashMap<>();
//        try {
//            // Daten aus Datei laden
//            List<Entry> entries = FileUtils.fromUrl(new URL("https://data.statistik.gv" +
//                    ".at/data/OGD_gest_kalwo_GEST_KALWOCHE_100.csv"));
//            // Jede "Zeile" zu Map hinzufügen
//            for (Entry entry : entries) {
//                // Aktuellen Wert aus Map für Jahr holen (oder 0)
//                int deathsInYear = perYear.getOrDefault(entry.getYear(), 0);
//                // Entry dazurechnen
//                deathsInYear += entry.getDeaths();
//                // neuen Wert für Jahr in Map setzen
//                perYear.put(entry.getYear(), deathsInYear);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        perYear.forEach((year, deaths) -> {
//            System.out.printf("Year %d: %d\n", year, deaths);
//        });
//    }
}

package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileBlacklistService implements BlacklistService{
    // Dateiname definieren
    private static final String FILE_NAME = "blacklist.txt";

    @Override
    public void addNames(List<String> names) {
        // Namen in die Blacklist reinschreiben

        try {
            FileWriter fw = new FileWriter(FILE_NAME, true);

            for(int i = 0; i < names.size(); i++){
                // .get(i) holt einen Eintrag aus der Liste
                String name = names.get(i);

                // Name in die Datei schreiben
                fw.write(name);
                // Zeilenumbruch in Datei schreiben
                fw.write(System.lineSeparator());
            }

            // Datei schließen
            fw.close();
        } catch (IOException e){
            System.out.println("Fehler beim Schreiben" +
                    "der Datei: " + e.getMessage());
        }

    }

    @Override
    public List<String> getNames() {
        List<String> result = new ArrayList<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            // Solange es eine nächste (neue) Zeile gibt ...
            while ((line = reader.readLine()) != null){
                result.add(line);
            }
        } catch (IOException e){
            System.out.println("Fehler beim Lesen der Datei: " + e.getMessage());
        } finally {
            // Finally wird immer ausgeführt!
            try {
                reader.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        // Liste sortieren
        Collections.sort(result);
        //Collections.sort(result, Collections.reverseOrder());

        return result;
    }

    @Override
    public void removeNames(List<String> names) {
        List<String> currentNames = getNames();
        // removeAll <-- entfernt aus currentNames alle Einträge die auch in names sind
        currentNames.removeAll(names);

        // Datei überschreiben
        try {
            FileWriter fw = new FileWriter(FILE_NAME, false);

            for(int i = 0; i < currentNames.size(); i++){
                // .get(i) holt einen Eintrag aus der Liste
                String name = currentNames.get(i);

                // Name in die Datei schreiben
                fw.write(name);
                // Zeilenumbruch in Datei schreiben
                fw.write(System.lineSeparator());
            }

            // Datei schließen
            fw.close();
        } catch (IOException e){
            System.out.println("Fehler beim Schreiben" +
                    "der Datei: " + e.getMessage());
        }
    }
}

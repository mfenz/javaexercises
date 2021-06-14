package at.cb.filename;

import at.cb.filename.model.Datei;

import java.io.File;
import java.util.ArrayList;

public class FileManager {
    public static void main(String[] args){
        FileManager fm = new FileManager();
        fm.readFolder();
    }

    public void readFolder(){
        File folder = new File("dateien");
        // Gibt ein Array von allen Dateien innerhalb des Ordners zurück
        File[] files = folder.listFiles();

        ArrayList<Datei> dateien = new ArrayList<>();

        for(File file : files){
            // Objekt der Klasse Datei erzeugen
            Datei datei = new Datei(file.getName());
            // Objekt der Klasse Datei in Liste einfügen
            dateien.add(datei);
        }

        for(Datei datei : dateien){
            print(datei);
        }
    }

    public void print(Datei datei){
        /**
         * Name: img-123.jpg
         * Dateityp: jpg
         * ID: 123
         */
        String dateiname = datei.getName();
        System.out.println("Name: " + dateiname);

        String typ = datei.getDateityp();
        System.out.println("Dateityp: " + typ);

        try {
            int id = datei.getId();
            System.out.println("ID: " + id);
        } catch (Exception e){
            System.out.println("ID: " + e.getMessage());
        }

    }
}

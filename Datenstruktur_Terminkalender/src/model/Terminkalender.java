package model;

public class Terminkalender {
    public static void main(String[] args) {
        // Datenstruktur: Array mit 24 Plätzen
        String[] termine = new String[24];
        termine[8] = "Telefonat Gruber";
        termine[9] = "Teamsitzung";
        termine[10] = "Teamsitzung";
        termine[12] = "Mittagessen";

        // Ausgabe aller Termine
        for(int i = 0; i<termine.length; ++i){
            System.out.println(i + termine[i]);
        }
    }
}

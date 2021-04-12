public class Schachbrett {
    public static void main(String[] args) {
        // 8 Zeilen
        // 8 Spalten
        int[][] spielfeld = new int[8][8];

        // Spielfeld an Stelle
        // Zeile 3
        // Spalte 5
        spielfeld[3][5] = 4;

        for(int zeile = 0; zeile < spielfeld.length; zeile++){
            for(int spalte = 0; spalte < spielfeld[zeile].length; spalte++){
                System.out.print(" " + spielfeld[zeile][spalte]);
            }
            // Zeilenumbruch nachdem alle Spalten einer Zeile ausgegeben wurden
            System.out.println();
        }
    }
}

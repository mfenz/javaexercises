public class Main {
    public static void main(String[] args) {
        // Bsp 1: Zeile für Zeile ausgeben
        String[] words = {"Java", "ist", "super!", "Oder?"};
        for(int i = 0; i < words.length; i++){
            System.out.println(words[i]);
        }

        // Bsp 2: Geben Sie mit Hilfe einer for-Schleife jedes Element mit
        // Beistrich getrennt in einer Zeile aus.
        // Nach dem letzten Element soll kein Beistrich ausgegeben werden.
        String[] names = {"Hansi", "Susi", "Peter", "Friedrich Maier"};
        for(int i = 0; i < names.length; i++){
            System.out.print(names[i]);
            if(i != names.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println();


        // Name:             Peter, Anzahl Zeigen:  5
        // Name:   Friedrich Maier, Anzahl Zeichen: 15
        System.out.printf("Name: %20s, Anzahl Zeichen: %2d %n", "Peter", "Peter".length());
        System.out.printf("Name: %20s, Anzahl Zeichen: %2d %n", "Friedrich Maier", "Friedrich Maier".length());
    }
}
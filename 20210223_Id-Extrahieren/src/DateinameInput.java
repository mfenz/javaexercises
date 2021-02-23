import java.util.Scanner;

public class DateinameInput {
    public static void main(String[] args) {
        DateinameInput di = new DateinameInput();
        di.idExtrahieren();
    }

    public String input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte den Dateinamen " +
                "im Format img-31234.jpg eingeben:");
        String dateiname = scanner.nextLine();
        return dateiname;
    }

    public void idExtrahieren(){
        // Methode input liefert uns den Dateinamen
        // Resultat der Methode input() auf String-Variable input schreiben
        String input = input();

        // Objekt erstellen und lokaler Variable dn zuweisen
        Dateiname dn = new Dateiname(input);
        // Ergebnis der Methode idExtrahieren() auf int-Variable id speichern
        int id = dn.idExtrahieren();

        System.out.printf("ID des Dateinamens %s = %d", input, id);
    }
}

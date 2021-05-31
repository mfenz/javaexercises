package at.cb.schaltjahrtest.model;

public class Jahr {
    // Instanzvariable jahr
    private int jahr;

    // Instanzvariablen über den Konstruktor initialisieren
    // Konstruktor: wird aufgerufen wenn mit "new" ein neues Objekt der Klasse erstellt wird
    public Jahr(int jahr){
        // this.jahr <-- bezieht sich auf die Instanzvariable jahr
        this.jahr = jahr;
    }

    public boolean isSchaltjahr(){
        if(jahr % 4 == 0 && jahr % 100 != 0){
            return true;
        }
        if(jahr % 100 == 0 && jahr % 400 != 0){
            return false;
        }
        if(jahr % 400 == 0){
            return true;
        }
        return false;
    }

    // Public Getter-Methoden für private Instanzvariablen
    public int getJahr(){
        // Gibt den Wert der private int Variable jahr zurück
        return jahr;
    }
}

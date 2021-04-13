package at.cb.ttt.model;

public class Player {
    // Instanzvariablen
    private String name;
    private char symbol;

    // Konstruktor
    public Player(String name, char symbol){
        // Übergabeparameter den Instanzvariablen
        // zuweisen
        this.name = name;
        this.symbol = symbol;
    }

    // Getter-Methoden
    public String getName(){
        return name;
    }

    public char getSymbol(){
        return symbol;
    }
}

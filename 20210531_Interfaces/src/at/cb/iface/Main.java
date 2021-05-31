package at.cb.iface;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        //m.play();
        m.heizen();
    }

    public void heizen(){
        Switchable waermeerzeuger;
//        waermeerzeuger = new Solaranlage();
//        waermeerzeuger = new Heizkessel();
        waermeerzeuger = new FernwaermeStation();

        waermeerzeuger.switchOn();

    }

    public void play(){
        // Liste: Objekte darin müssen vom Datentyp Moveable sein
        // das heißt: Objekte müssen das Interface Moveable implementieren
        // Spitze Klammern: Generics (geben an, welche Objekte von welchem Datentyp
        // innerhalb der Liste gespeichert werden können )
        List<Moveable> objekte = new ArrayList<>();
        // Objekte in die Liste einfügen
        objekte.add(new Fahrrad("rot", 0f, 0f));
        objekte.add(new Fahrrad("gelb", 0f, 5f));
        objekte.add(new Baum(100));
        objekte.add(new Baum(2));

        for(int i = 0; i < 100; i++){
            for(Moveable moveable : objekte){
                moveable.move();
            }
        }
    }
}

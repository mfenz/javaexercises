import model.FARBE;
import model.Osterei;

public class Fabrik {
    public static void main(String[] args) {
        Fabrik fabrik = new Fabrik();
        fabrik.ostereierFaerben();
    }

    public void ostereierFaerben(){
        Osterei o1 = new Osterei(FARBE.GRUEN);
        Osterei o2 = new Osterei(FARBE.BLAU);

        if(o1.getFarbe() == FARBE.ROT){
            System.out.println("Das Ei ist rot!");
        } else {
            System.out.println("Das Ei ist nicht rot!");
        }
    }
}

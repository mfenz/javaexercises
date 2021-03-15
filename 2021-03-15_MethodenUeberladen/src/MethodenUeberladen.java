import models.Quadrat;
import models.Rechteck;

public class MethodenUeberladen {

    public static void main(String[] args) {
        MethodenUeberladen mu = new MethodenUeberladen();
        mu.testen();
    }

    public void testen() {
        Quadrat quadrat1 = new Quadrat(5.0f);
        print(quadrat1);

        Quadrat quadrat2 = new Quadrat(1234.456f);
        print(quadrat2);

        Rechteck rechteck1 = new Rechteck(2.5f, 1.2f);
        print(rechteck1);
        Rechteck rechteck2 = new Rechteck(20.5f, 31.2f);
        print(rechteck2);
        print(5.0f);
        print(5);
        print(5 > 10);
        System.out.println(5);
        System.out.println(5.0f);
        System.out.println("5");
        System.out.println();
    }

    private void print(Quadrat q) {
        System.out.printf("Quadrat: Fläche=%f Umfang=%f \n",
                q.getFlaeche(), q.getUmfang());
    }

    private void print(Rechteck r) {
        System.out.printf("Rechteck: Fläche=%f Umfang=%f \n",
                r.getFlaeche(), r.getUmfang());
    }
    private void print(int i){
        System.out.println("Int: " +i );
    }
    private void print(float f){
        System.out.printf("Float %f\n", f);
    }
    private void print(boolean b){
        if(b){
            System.out.println("Ist wahr!");
        } else {
            System.out.println("Ist falsch!");
        }
    }

}

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Schneckenrennen {
    private float distanz;

    private List<Schnecke> teilnehmer = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public Schneckenrennen(float distanz) {
        this.distanz = distanz;
    }

    public static void main(String[] args) {
        Schneckenrennen rennen = new Schneckenrennen(20);
        rennen.addSchnecken();
        rennen.rennen();
    }

    public void addSchnecken(){
//        teilnehmer.add(new Gehaeuseschnecke("Tiger", 2.4f, "gelb"));
//        teilnehmer.add(new Gehaeuseschnecke("Speedy", 3.0f, "rot"));
//        teilnehmer.add(new Nacktschnecke("Cookie", 2.2f));

        System.out.println("Wie viele Nacktschnecken sollen teilnehmen?");
        int anzahlNacktschnecken = scanner.nextInt();
        addNacktschnecken(anzahlNacktschnecken);
    }

    private void addNacktschnecken(int anzahl){
        for(int i = 0; i < anzahl; ++i){
            System.out.println("Bitte den Namen der Nacktschnecke eingeben:");
            String name = scanner.next();
            System.out.println("Bitte speed eingeben: ");
            float speed = readSpeed();
            teilnehmer.add(new Nacktschnecke(name, speed));
        }
    }

    private float readSpeed(){
        boolean success = false;
        while(!success){
            try {
                return scanner.nextFloat();
            } catch (InputMismatchException e){
                System.out.println("Falsche Eingabe! Bitte wiederholen:");
                scanner.nextLine();
            }
        }
        return 0.0f;
    }

    public void rennen(){
        boolean gewonnen = false;
        while(!gewonnen){

//            for(int i = 0; i < teilnehmer.size(); i++){
//                Schnecke schnecke = teilnehmer.get(i);
//                schnecke.kriechen();
//            }

            for(Schnecke schnecke : teilnehmer){
                schnecke.kriechen();
                float zurueckgelegteDistanz = schnecke.getZurueckgelegteDistanz();
                if(zurueckgelegteDistanz >= distanz){
                    gewonnen = true;
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Todo gewinner prüfen

    }

    public void displayWinner(Schnecke winner){

    }
}

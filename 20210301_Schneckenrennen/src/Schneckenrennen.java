import java.util.ArrayList;
import java.util.List;

public class Schneckenrennen {
    private float distanz;

    private List<Schnecke> teilnehmer = new ArrayList<>();

    public Schneckenrennen(float distanz) {
        this.distanz = distanz;
    }

    public static void main(String[] args) {
        Schneckenrennen rennen = new Schneckenrennen(20);
        rennen.addSchnecken();
        rennen.rennen();
    }

    public void addSchnecken(){
        teilnehmer.add(new Gehaeuseschnecke("Tiger", 2.4f, "gelb"));
        teilnehmer.add(new Gehaeuseschnecke("Speedy", 3.0f, "rot"));
        teilnehmer.add(new Nacktschnecke("Cookie", 2.2f));
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

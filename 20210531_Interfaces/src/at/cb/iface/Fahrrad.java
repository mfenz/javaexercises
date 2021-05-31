package at.cb.iface;

public class Fahrrad implements Moveable{
    private String farbe;
    private float geschwindigkeit;
    private float zurueckgelegteDistanz;

    public Fahrrad(String farbe, float geschwindigkeit, float zurueckgelegteDistanz){
        // Die Übergabeparameter auf Instanzvariablen zuweisen
        this.farbe = farbe;
        this.geschwindigkeit = geschwindigkeit;
        this.zurueckgelegteDistanz = zurueckgelegteDistanz;
    }

    @Override
    public void move() {
        zurueckgelegteDistanz += geschwindigkeit;
        geschwindigkeit += 0.1f;
        String farbe = this.farbe;
        if(!farbe.endsWith("e")){
            farbe += "e";
        }
        System.out.printf("Das %s Fahrrad fährt mit %.2f km/h und ist schon %.2f weit gekommen. %n",
                farbe, geschwindigkeit, zurueckgelegteDistanz);
    }
}

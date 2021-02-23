public class Dateiname {
    private String dateiname;

    // Konstruktor
    public Dateiname(String dateiname){
        this.dateiname = dateiname;
    }

    // Methode: Input z. B. img-31234.jpg --> 31234
    // Methode: Input z. B. img-1.jpg --> 1
    public int idExtrahieren(){
        // wo ist der Bindestrich?
        int start = dateiname.indexOf("-");
        // Wo ist der Punkt?
        int end = dateiname.indexOf(".");
        String id = dateiname.substring(start+1, end);
        // Integer.parseInt(string) wandelt String in int um
        return Integer.parseInt(id);
    }
}

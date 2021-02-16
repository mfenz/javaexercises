import java.util.HashMap;
import java.util.Map;

public class Telefonbuch {
    Map<String, Integer> b = new HashMap<>();
    void neuerKunde(String name, int num){
        // Einfügen
        b.put("Marc", 436641234);
    }
    int abfrage(String name){
        int num = b.get("Marc");
        return num;
    }

    public static void main(String[] args) {
        Telefonbuch t = new Telefonbuch();
        t.neuerKunde("Marc", 436641234);
        System.out.println(t.abfrage("Marc"));
    }
}

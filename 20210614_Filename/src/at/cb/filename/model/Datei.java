package at.cb.filename.model;

public class Datei {
    /**
     * Instanzvariablen
     */

    // z. B. abc-1234.jpg
    private String name;

    /**
     * Konstruktor
     */
    public Datei(String name){
        // Zuweisung vom Übergabeparameter auf die Instanzvariable
        this.name = name;
    }

    public String getDateityp(){
        // z. B. abc-1234.jpg --> jpg
        // z. B. nix.docx --> docx
        // z. B. abc.def.xyz --> xyu
        // z. B. nixgarnix --> ""
        // z. B. nixgarnix. --> ""

        // wo ist der letzte Punkt?
        int posPunkt = name.lastIndexOf(".");
        // Leeren String zurückgeben wenn kein Dateityp vorhanden ist
        if(posPunkt < 0){
            return "";
        }

        String typ = name.substring(posPunkt + 1);
        return typ;
    }


    public int getId() throws Exception {
        // img-321.jpg
        // img-1.jpg
        // bild-444.png
        // bild-.png
        // img-hahaha.png
        int posBindestrich = name.indexOf("-");
        int posPunkt = name.lastIndexOf(".");
        if(posBindestrich < 0 || posPunkt < 0 || posBindestrich > posPunkt
                || posBindestrich + 1 == posPunkt){
            throw new Exception("Keine ID gefunden");
        }

        try {
//            String idStr = name.substring(posBindestrich + 1, posPunkt); // 444
//            // String in int umwandeln
//            int id = Integer.parseInt(idStr);

            int id = Integer.parseInt(name, posBindestrich + 1, posPunkt, 10);
            return id;
        } catch (NumberFormatException e){
            throw new Exception(
                    String.format("%s ist keine ID!", name.substring(posBindestrich + 1, posPunkt))
            );
        }
    }

    /**
     * Getter-Methoden werden für private Instanzvariablen
     * geschrieben
     * @return
     */

    public String getName(){
        return name;
    }
}

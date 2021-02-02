public class FindeDenString {
    // Instanzvariablen
    // substring(1,3)
    // abcdefgh
    private String text;
    private char search;

    // Konstruktor
    public FindeDenString(String text, char search){
        this.text = text;
        this.search = search;
    }

    public void findeDenString(){
        // index ist -1 wenn "search" nicht gefunden wurde.
        int index = text.indexOf(search);
        System.out.printf("Zeichenkette: \"%s\"\n", text);
        System.out.printf("Zeichen: \"%s\"\n", search);
        if(index >= 0){
            System.out.printf("Das Zeichen liegt an der Stelle: %d\n", index+1);
        } else {
            System.out.println("Leider ist dieses Zeichen nicht in dieser Zeichenkette enthalten");
        }

        System.out.println();
    }
}

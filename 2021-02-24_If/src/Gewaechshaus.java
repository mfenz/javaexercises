public class Gewaechshaus {
    public static void main(String[] args){
        // Deklaration: Datentyp Variablenname - legt neue Variable im Speicher an
        // Deklaration: im Speicher einen Platz für einen Wert
        int wassertankMaxVolumen = 1500;
        int wassertankVolumen = 599;
        int einzelneFuellmenge = 1000;

        System.out.println("Lehrling schaut ob er den Tank füllen muss?");
        if(wassertankVolumen < 600){
            // Oje! Im Wassertank sind nur mehr 0 Liter.
            // Oje! Im Wassertank sind nur mehr {wassertankVolumen} Liter.
            System.out.printf("Oje! Im Wassertank sind nur mehr %d Liter. Wir müssen tanken. \n", wassertankVolumen);

            wassertankVolumen += einzelneFuellmenge;

        } else {
            System.out.println("Wassertank ist noch voll genug!");
        }

        System.out.println("jetzt kommt der Techniker ...");
        if(wassertankVolumen > wassertankMaxVolumen){
            System.out.printf("Im Wassertank sind %d Liter! Viel zu viel! Maximal erlaubt sind %d!\n", wassertankVolumen, wassertankMaxVolumen);
        } else {
            System.out.println("Wassertank-Volumen ist eh in Ordnung...");
        }
    }
}

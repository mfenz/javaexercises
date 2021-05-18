package at.cb.sc;

public class SwitchCaseUebungen {
    public static void main(String[] args) {
        // BEDINGUNG ist ein boolesche'r Ausdruck
//        int zahl = 17;
//        boolean x = (zahl > 15 && zahl < 30);
//        if(zahl > 15 && zahl < 30){
//
//        }
//        // if(BEDINGUNG) {  }
//        char geschlecht = 'o';
//        // switch(Variable die überprüft werden soll)
//        switch(geschlecht)
//        {
//            // case WERT: <-- wenn WERT == Variable die überprüft werden soll, dann in case reingehen
//            case 'm':
//                System.out.println("Geschlecht ist männlich.");
//                // break; beendet das switch
//                break;
//            case 'w':
//                System.out.println("Geschlecht ist weiblich.");
//                break;
//            default:
//                // wenn kein case zugetroffen hat
//                System.out.println("Geschlecht nicht erkannt.");
//                break;
//        }
//        System.out.println("Nach dem switch");


//        String farbe = "gelb";
//        switch (farbe)
//        {
//            case "rot":
//                System.out.println("Der Apfel ist rot.");
////                break;
//            case "blau":
//                System.out.println("Der Himmel ist blau!");
//                break;
//            case "zitronengelb":
//                System.out.println("Die Zitrone ist zitronengelb.");
////                break;
//            case "grün":
//                System.out.println("Das Gras ist grün.");
////                break;
//            default:
//                System.out.println("Regenbogen");
//        }

        int alter = 33;
        switch (alter) {
            case 16:
            case 17:
                System.out.println("Wir dürfen ein Bier trinken, und wählen gehen.");
                break;
//            case 18:
//                System.out.println("Wir dürfen jetzt alles!!!");
//                break;
            default:
                System.out.println("Du darfst entweder alles, oder nichts.");
        }



        String eingabe = "";

        switch (eingabe) {
            case "add" :
                // Code um neuen Eintrag einzufügen
                break;
            case "list":
                // Code um alle Einträge darzustellen
                break;
            case "exit":
                // Programm beenden
                System.exit(0);
        }


    }
}

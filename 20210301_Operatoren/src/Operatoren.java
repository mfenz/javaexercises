public class Operatoren {
    public static void main(String[] args) {

        /**
         * Arithmetische Operatoren
         */

        int a = 5 + 3;
        int b = 5 / 3;
        //  += *= /= -=
        int x = 1;

        // Zwei verschiedene Schreibweisen:
        x = x + 5; // gleich wie x+= 5
        x += 5; // gleich wie x = x + 5

        // Zwei verschiedene Schreibweisen:
        x = x * 5;
        x *= 5;

        // Zwei verschiedene Schreibweisen:
        x = x / 5;
        x /= 5;

        // Zwei verschiedene Schreibweisen:
        x = x - 5;
        x -= 5;

        // Modulo --> %
        int rest = 98 % 100; // rest ist 98 ergibt sich aus 98 / 100 --> 0 mal und 98 Rest
        rest = 5 % 2; // 5/2 = 2 und 1 Rest

        x = 0;
        // x++
        // ++x
        System.out.println("x++");
        // Zahl verwenden und dann erhöhen
        System.out.println(x++); // liest die Zahl 0, gibt aus, und erhöht dann um 1
        System.out.println("x=" + x);

        System.out.println();
        x = 0;
        System.out.println("++x");
        // Zahl erhöhen und dann verwenden
        System.out.println(++x); // erhöht um 1, list die Zahl 1, gibt aus
        System.out.println("x=" + x);


        //for(int i = 0; i < 10; ++i){
        for(int i = 0; i < 10; i++){

        }

        String[] monate = new String[12];
        int i = 0;
        monate[i++] = "J"; // J auf index 0
        monate[i] = "F"; // F auf Index 1
        monate[++i] = "M"; // M auf Index 2


        /**
         * Vergleichs-Operatoren
         */
        x = 5;
        // == ... Vergleichsoperator (gleich)
        if(x == 5){

        }
        // x ... Zuweisungsoperator
        x = 5; // Zuweisungsoperator
//        if(x = 5){
//
//        }

        // Ungleich-Operator
        if(x != 5){

        }

        int y = 10;
        // Logische Und-Verknüpfung
        if(x == 5 && y != 5){

        }
        // Logische Oder-Verknüpfung
        if(x == 5 || y != 5){

        }

        x = 5;
        // kleiner
        if(x < 5){

        }
        // kleiner gleich
        if(x <= 5){

        }
        // gleich
        if(x == 5){

        }
        // ungleich
        if(x != 5){

        }
        // größer gleich
        if(x >= 5){

        }
        // größer
        if(x > 5){

        }

        boolean b = false;
        // Rufzeichen-Operator
        b = !b; // --> dreht Wahrheitswert um


        while(!b){
            break;
        }









        // int: 32 bit
        // 1111 1111 1111 1111 1111 1111 1010 0001
        // um 4 Bits nach rechts shiften und mit 0 auffüllen
        // 0000 1111 1111 1111 1111 1111 1111 1010      ~ Tilde

    }
}

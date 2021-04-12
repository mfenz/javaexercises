package at.cb.init;

public class InitDurchSchleife {
    public static void main(String[] args) {
        int startInt = 3;
        int[] potenzen = new int[8];
        for(int i = 0; i < potenzen.length; i++){
            potenzen[i] = (int)Math.pow(startInt, i+1);
            // Potenz ausgeben
            System.out.print(potenzen[i]);
            System.out.print(" (");

            for(int j = 0; j < i+1; j++){
                System.out.print(startInt);
                if(j != i){
                    System.out.print(" * ");
                }
            }

            System.out.print(")");
            // Am Ende der Zeile --> Zeilenumbruch
            System.out.println();
        }
    }
}

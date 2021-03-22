import java.util.Scanner;

public class ArrayResize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int anzProdukte = 0;
        String[] produkte = new String[3];

        String eingabe = "";
        while(!eingabe.equals("done")){
            System.out.println("Produktname eingeben:");
            eingabe = scanner.nextLine();

            if(anzProdukte == produkte.length){
                System.out.println("Resize!");
                String[] neu = new String[produkte.length * 2];
                for(int i = 0; i < produkte.length; i++){
                    neu[i] = produkte[i];
                }
                produkte = neu;
            }

            produkte[anzProdukte] = eingabe;
            /// HIER
            ArrayResize.printProdukte(produkte);
            anzProdukte++;
        }
    }

    private static void printProdukte(String[] produkte){
        for(int i = 0; i < produkte.length; ++i){
            System.out.print(produkte[i] + ", ");
        }
        System.out.println();
    }
}

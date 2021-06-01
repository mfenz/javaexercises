package at.cb.ex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Instanzvariablen mit primitiven Datentypen werden mit der Zahl 0 initialisiert
    private int x;

    // Instanzvariablen mit komplexen Datentypen werden mit null initialisiert
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main m = new Main();
//        m.testen();
        //m.arrayTest();
//        try {
//            m.files();
//        } catch (IOException e){
//            System.out.println("Fehler! " +e.getMessage());
//        }
        m.nameInput();

    }

    public void nameInput(){
        List<String> blacklist = new ArrayList<>();
        // blacklist wird mit Werten aus der Datenbank/File gefüllt


        try {
            System.out.println("Bitte einen Namen eingeben:");
            String name = scanner.nextLine();
            if(blacklist.contains(name)){
                throw new UngueltigerNameException();
            }


            if(name.equalsIgnoreCase("Görhard") || name.equalsIgnoreCase("Stefan")){
                throw new UngueltigerNameException();
            }
            System.out.println("Herzlich willkommen " + name);
        } catch (UngueltigerNameException e){
            System.out.println("Es wurde ein ungültiger Name eingegeben. Meinten Sie Görnot?");
        }

    }

    public void files() throws IOException {
        File fout = new File("A:\\asdf\\out.txt");
        FileOutputStream fos = new FileOutputStream(fout);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        for (int i = 0; i < 10; i++) {
            bw.write("something");
            bw.newLine();
        }

        bw.close();

    }

    public void arrayTest(){
        String[] orte = {"Graz", "Wien", "Salzburg"};
        try {
            for(int i = orte.length - 1; i >= 0; i--){
                System.out.println(orte[i]);

                Thread.sleep(1000);
            }
        } catch (InterruptedException e){

        }

    }

    public void testen(){
        // Lokale Variable
        // x wurde deklariert, aber nicht initialisiert
        // Lokale Variablen müssen immer initialisiert werden bevor sie
        // verwendet werden können
        int x;
        x = 9;
        System.out.println(x);


        System.out.println("Bitte eine Zahl eingeben:");
        int zahl = scanner.nextInt();
        if(zahl == 0){
            System.out.println("Nicht die Zahl 0 eingeben!");
        }

        try {
            int ergebnis = 10 / zahl;
            System.out.println("Das Ergebnis ist " + ergebnis);
        } catch (ArithmeticException e){
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        } catch (NullPointerException e){
            // ...
        } catch (Exception e){
            // ...
        }

        System.out.println("Jetzt rechnen wir weiter ... ");


    }
}

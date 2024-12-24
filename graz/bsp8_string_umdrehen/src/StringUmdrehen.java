import java.util.List;
import java.util.Scanner;

public class StringUmdrehen {
    public void umdrehen(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte einen Text eingeben der umgedreht werden soll:");
        String eingabe = scanner.nextLine();

        for(int i = eingabe.length() - 1; i >= 0; i--){
            System.out.print(eingabe.charAt(i));
        }
    }

    public void ausgabeLaenge(){
        String[] names = {"Hansi", "Susi", "Peter", "Friedrich Maier"};
        for(String name :names){
            System.out.printf("Name: %17s, Anzahl Zeigen: %2d%n", name, name.length());
        }

        for(int i = 0; i < names.length; i++){
            System.out.print(names[i]);
            if(i != names.length - 1){
                System.out.print(", ");
            }
        }

        String[] words = {"Java", "ist", "super!", "Oder?"};
        for(String word : words){
            System.out.println(word);
        }
    }
}

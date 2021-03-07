import service.CommaSeparatedPersistenceService;
import service.LineByLinePersistenceService;
import service.PersistenceService;

import java.io.File;
import java.util.Scanner;

public class TextInput {
    private PersistenceService persistenceService;

    public TextInput(PersistenceService persistenceService) {
        this.persistenceService = persistenceService;
    }

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte einen Text eingeben:");
        String text = scanner.nextLine();
        File outputFile = new File("line.txt");
        persistenceService.save(text, outputFile);
    }

    public static void main(String[] args) {
        TextInput ti = new TextInput(new LineByLinePersistenceService());
//        TextInput ti = new TextInput(new CommaSeparatedPersistenceService());
        ti.input();
    }
}

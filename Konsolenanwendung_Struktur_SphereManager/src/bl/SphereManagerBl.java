package bl;
import model.Sphere;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Business logic oder business layer
 */
public class SphereManagerBl {
    // wird über Konstruktor initialisiert
    private Scanner scanner;
    // Generics: <Sphere> gibt den Datentyp der Elemente in der Liste an
    private List<Sphere> spheres = new ArrayList<>();
    public SphereManagerBl(Scanner scanner) {
        this.scanner = scanner;
    }
    public void addSphere() {
        System.out.println("Bitte den Namen eingeben:");
        String name = scanner.nextLine();
        System.out.println("Bitte den Durchmesser eingeben:");
        while (!scanner.hasNextDouble()){
            System.out.println("Bitte eine gültige Zahl eingeben!");
            scanner.next(); // clear input stream buffer
        }
        double radius = scanner.nextDouble();
        scanner.nextLine(); // Zeilenumbruch vom Buffer holen
        Sphere sphere = new Sphere(name, radius);
        spheres.add(sphere);
        System.out.println("Ball hinzugefügt:");
        print(sphere);
    }
    public void listSpheres() {
        for(Sphere sphere : spheres){
            print(sphere);
        }
    }
    public void print(Sphere sphere) {
        System.out.printf("%s, r=%f V=%f %n",
                sphere.getName(),
                sphere.getRadius(),
                sphere.getVolume());
    }
}

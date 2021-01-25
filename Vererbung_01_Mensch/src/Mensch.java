import java.util.ArrayList;
import java.util.List;

public class Mensch {
    private String name;

    public Mensch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void printInfo(){
        System.out.printf("Ich bin %s, ein Mensch.\n", name);
    }
}

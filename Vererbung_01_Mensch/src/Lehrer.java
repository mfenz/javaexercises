/**
 * Lehrer ist ein Mensch. Hat einen Namen und Gedanken.
 */
public class Lehrer extends Mensch {
    private int dienstjahre;

    public Lehrer(String name, int dienstjahre) {
        super(name);
        this.dienstjahre = dienstjahre;
    }

    public int getDienstjahre() {
        return dienstjahre;
    }
    public void setDienstjahre(int dienstjahre) {
        this.dienstjahre = dienstjahre;
    }
}

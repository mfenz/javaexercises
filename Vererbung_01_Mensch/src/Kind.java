/**
 * Kind ist ein Mensch. Hat einen Namen und Gedanken.
 */
public class Kind extends Mensch{
    private int schulstufe;

    public Kind(String name, int schulstufe) {
        super(name);
        this.schulstufe = schulstufe;
    }

    public int getSchulstufe() {
        return schulstufe;
    }
    public void setSchulstufe(int schulstufe) {
        this.schulstufe = schulstufe;
    }
}

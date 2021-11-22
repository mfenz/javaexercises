package at.cb.comparison;

import java.util.Objects;

public class Person {
    private String vorname;
    private String nachname;

    public Person(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(vorname,
                person.vorname) && Objects.equals(nachname,
                person.nachname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vorname, nachname);
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
}

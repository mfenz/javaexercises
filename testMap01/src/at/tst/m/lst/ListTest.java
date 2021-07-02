package at.tst.m.lst;

import at.tst.m.hm.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListTest {
    public static void main(String[] args) {

        listToSet();

    }

    public static void play(){
        List<String> names = new ArrayList<>();

        // "names" mit Elementen befüllen ...

        // Iterator für Collection holen
        Iterator<String> iter = names.iterator();

        // Solange es ein weiteres Element gibt ...
        while (iter.hasNext()){

            // .next() holt nächstes Element aus Collection
            String name = iter.next();

            // Lösche Namen die mit "A" beginnen
            if(name.startsWith("A")){

                // Lösche Element aus Collection
                iter.remove();
            }
        }


        List<Integer> list = new ArrayList<>();

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer element = iterator.next();

        }
    }

    public static void forEachLoop(){

        /**
         * SET
         */
        Set<Integer> set = Set.of(1, 5, 10, 20);

        // For-Each Loop
        for (Integer i : set){
            System.out.printf("Set Element: %d %n", i);
        }


        /**
         * LIST
         */
        List<String> list = List.of("Hansi", "Susi", "Rudi");

        // For-Each Loop
        for(String s : list){
            System.out.printf("List Element: %s %n", s);
        }

    }

    public static void iteratorList(){
        /**
         * Iteration einer Liste
         */
        List<String> list = List.of("A", "B", "C");

        // Iterator für "list" holen
        Iterator<String> iter = list.iterator();

        /**
         * Collection mit Iterator durchlaufen.
         * Solange die Collection ein nächstes Element hat ...
         * hasNext() liefert true wenn die Iteration weitere Elemente hat.
         */
        while (iter.hasNext()){

            // Element aus Collection holen mit .next()
            String element = iter.next();

            System.out.printf("Element: %s %n", element);
        }
    }

    public static void iteratorMap(){
        /**
         * Iteration einer Map
         */

        Map<Integer, String> map =
                Map.of(1, "eins", 2, "zwei", 3, "drei");

        /**
         * map.entrySet() liefert die Einträge der Map
         * als Set von Key-Value Paaren
         *
         * Ein Set ist eine Collection und implementiert das
         * Interface Iterable
         */
        Iterator<Map.Entry<Integer, String>> iter
                = map.entrySet().iterator();

        while (iter.hasNext()){

            // Ein Map.Entry<K, V> stellt ein Key-Value Paar dar
            Map.Entry<Integer, String> pair = iter.next();

            int key = pair.getKey();
            String value = pair.getValue();

            System.out.printf("K: %d V: %s %n", key, value);
        }
    }

    public static void removeIteratorMap(){
//        Map<Integer, String> map =
//                Map.of(1, "eins", 2, "zwei", 3, "drei");

        // Map-Objekt erzeugen und mit Key-Value-Paaren füllen
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "eins"); map.put(2, "zwei"); map.put(3, "drei");

        // Iterator für Map-Einträge holen (über entrySet())
        Iterator<Map.Entry<Integer, String>> iter
                = map.entrySet().iterator();

        // Über die Map iterieren
        while (iter.hasNext()){

            // Ein Map.Entry<K, V> stellt ein Key-Value Paar dar
            Map.Entry<Integer, String> pair = iter.next();

            int key = pair.getKey();
            String value = pair.getValue();

            // Elemente (values) die mit "z" beginnen aus Map löschen
            if(value.startsWith("z")){
                iter.remove();
            }
        }

        // Jedes (verbleibende) Element aus der Map ausgeben
        map.forEach((key, value) -> {
            System.out.printf("K: %d V: %s %n", key, value);
        });
    }

    public static void removeIteratorSet(){
        // Set anlegen und mit Werten befüllen
        Set<Integer> set = new HashSet<>();
        set.add(1); set.add(5); set.add(10); set.add(20);

        // Iterator für Set holen
        Iterator<Integer> iter = set.iterator();

        // Über set iterieren
        while (iter.hasNext()){

            // Element aus dem Set holen
            Integer i = iter.next();

            // Gerade Zahlen aus Set löschen
            if(i != null && i % 2 == 0){

                // Über Set iterieren und Element löschen
                iter.remove();
            }
        }

        for(int i : set){
            System.out.printf("Verbleibend: %d%n", i);
        }
    }

    public static void schnittmengeSet(){
        Set<Integer> a = new HashSet<>();
        a.add(1); a.add(5); a.add(10); a.add(20);

        Set<Integer> b = new HashSet<>();
        b.add(1);

        // in "a" bleibt nur was sowohl in "a" als auch "b" ist
        a.retainAll(b);

        // Ausgabe: [1]
        System.out.println(a);
    }

    public static void differenzSet(){
        Set<Integer> a = new HashSet<>();
        a.add(1); a.add(5); a.add(10); a.add(20);

        Set<Integer> b = new HashSet<>();
        b.add(1);

        // A ohne B
        a.removeAll(b);

        // Ausgabe: [20, 5, 10] <-- "a" ohne "b"
        System.out.println(a);

        // Ausgabe: [1]
        System.out.println(b);
    }

    public static void vereinigungsmengeSet(){
        Set<Integer> a = new HashSet<>();
        a.add(1); a.add(5); a.add(10); a.add(20);

        Set<Integer> b = new HashSet<>();
        b.add(1);
        b.add(999);

        // a und b (Vereinigungsmenge)
        // Alle Elemente aus b in a einfügen
        a.addAll(b);

        // Ausgabe: [1, 20, 5, 999, 10] <-- "a" UND "b"
        System.out.println(a);

        // Ausgabe: [1, 999]
        System.out.println(b);
    }

    public static void treeSetOrder(){
        TreeSet<User> set = new TreeSet<>();

        set.add(new User(5, "Hans"));
        set.add(new User(10, "Susi"));
        set.add(new User(1, "Rudi"));
        set.add(new User(20, "Mitzi"));

        // Elemente werden anhand der compareTo() Methode sortiert
        for(User u : set){
            System.out.printf("%d %s %n", u.id, u.name);
        }
    }

    public static void linkedHashSetTest(){
        // LinkedHashSet-Objekt erzeugen
        Set<Double> set = new LinkedHashSet<>();

        // Set mit Werten befüllen
        set.add(6.3);
        set.add(1.7);
        set.add(null);
        set.add(999.0);

        // Ausgabe in der Reihenfolge des Einfügens
        for(Double d : set){
            System.out.println(d);
        }
    }

    public static void hashSetTest(){
        // HashSet-Objekt erzeugen
        // <> ist der Diamond-Operator
        Set<Integer> set = new HashSet<>();

        // Werte in Set einfügen
        set.add(1); set.add(2); set.add(10);
        set.add(30); set.add(100); set.add(1);
        set.add(2);

        // Über Set iterieren und Elemente ausgeben
        for(Integer i : set){
            System.out.println(i);
        }
    }

    public static void hashSetLoeschen(){
        // HashSet-Objekt erzeugen
        Set<Integer> set = new HashSet<>();

        // Werte in Set einfügen (1, 2, 10, 30, 100)
        set.add(1); set.add(2); set.add(10); set.add(30); set.add(100);

        // Elemente aus Set löschen (10 und 100)
        set.remove(10);
        set.remove(100);

        // Über Set iterieren und Elemente ausgeben
        for(Integer i : set){
            System.out.println(i);
        }
    }

    public static void hashSetClear(){
        // HashSet-Objekt erzeugen
        Set<Integer> set = new HashSet<>();

        // Werte in Set einfügen (1, 2, 10, 30, 100)
        set.add(1); set.add(2); set.add(10);
        set.add(30); set.add(100); set.add(1);
        set.add(2);

        // Alle Elemente aus dem Set löschen
        set.clear();

        // Wie viele Elemente sind im Set?
        int anzElemente = set.size();

        // Im Set sind 0 Elemente.
        System.out.printf("Im Set sind %d Elemente.%n", anzElemente);

        // Über Set iterieren und Elemente ausgeben
        for(Integer i : set){
            System.out.println(i);
        }
    }

    public static void listToSet(){
        List<String> list = List.of("Graz", "Wien", "Linz", "Wien", "Graz");

        // Ausgabe: Liste: [Graz, Wien, Linz, Wien, Graz]
        System.out.println("Liste: " + list);

        // TreeSet-Objekt erzeugen und Liste übergeben
        Set<String> set = new TreeSet<>(list);

        // Ausgabe: Set: [Graz, Linz, Wien]
        System.out.println("Set: " + set);


    }
}

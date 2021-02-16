package model;

import java.util.ArrayList;
import java.util.LinkedList;

// Java Codebeispiel
public class Foo {
    public static void
    main(String[] args) {
        // Java Codebeispiel
        ArrayList<String> ar = new ArrayList<>();
        ar.add("X");
        ar.add(0, "Y");
        ar.get(0); // Y
        ar.remove(0);

        LinkedList<String> ll = new LinkedList<>();
        ll.add("LL");
        ll.add(0, "First?!");
        ll.get(1); // LL
        ll.remove(0);
    }
}

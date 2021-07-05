package at.cb.mylinkedlist;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args){

        LinkedList<String> llJDK = new LinkedList<>();

        MyLinkedList ll = new MyLinkedList();
        ll.add("Jänner");
        ll.add("Februar");
        ll.add("März");
        ll.add("April");

        // Löschen
        String geloescht = ll.remove(2);
        System.out.printf("Es wurde %s gelöscht.%n", geloescht);

        int anzahlElemente = ll.getSize();
        System.out.printf("In der Liste sind %d Elemente %n", anzahlElemente);

        for(int i = 0; i < ll.getSize(); i++){
            System.out.printf("Index %d, Value: %s %n", i, ll.get(i));
        }


    }
}

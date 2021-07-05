package at.cb.mylinkedlist;

import java.util.ArrayList;

public class MyLinkedList {
    private Node head;
    private int size;

    public void add(String s){
        Node node = new Node(s);

        // 1) wenn head null ist, dann ist node der head
        if(head == null){
            head = node;
        } else {
            // 2) wenn head nicht null ist, dann den letzten Knoten finden, und
            // neuen Knoten als next eintragen
            Node tail = getTail();
            tail.setNext(node);
        }

        size++;
    }

    public String remove(int index){
        // Knoten mit dem Index finden und den Wert merken
        String value;
        if(index == 0){
            value = head.getValue();
            head = head.getNext();
        } else {
            // Vorgänger-Knoten des zu löschenden Knoten suchen
            Node vorgaenger = head;
            for(int i = 0; i < index - 1; i++){
                vorgaenger = vorgaenger.getNext();
            }
            value = vorgaenger.getNext().getValue();
            vorgaenger.setNext(vorgaenger.getNext().getNext());
        }
        size--;
        return value;
    }

    public String get(int index){
        Node now = head;
        for(int i = 0; i < index; i++){
            now = now.getNext();
        }
        return now.getValue();
    }

    public int getSize(){
        return size;
    }

    private Node getTail(){
        Node now = head;
        while (now.getNext() != null){
            now = now.getNext();
        }
        return now;
    }
}

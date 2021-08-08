package at.cb.tt;

public class SyncIntList {
    private int size;
    private int[] data;

    public synchronized void add(int value){
        // add code ...
        size++;
    }

    public synchronized int getSize(){
        return size;
    }

    public synchronized int get(int index){
        return data[index];
    }

    public synchronized void remove(int index){
        // add code ...
        size--;
    }
}

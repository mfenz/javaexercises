package at.cb.ttt;

public class MyList<E> {
    private E[] data;
    public void add(E element){

    }

    public static void main(){
        MyList<String> liste = new MyList<>();
        liste.add("aasdf");

        MyList<Integer> zahlen = new MyList<>();
        zahlen.add(34);
    }
}

package at.cb.schaltjahrtest;

public class Schaltjahrtest {
    public static void main(String[] args) {
        // Für welches Jahr wollen wir es wissen?
        int jahr = 2021;


        if(jahr % 4 == 0 && jahr % 100 != 0){
            System.out.println(jahr + " ist ein Schaltjahr");
        } else if(jahr % 100 == 0 && jahr % 400 != 0){
            System.out.println(jahr + " ist kein Schaltjahr");
        } else if(jahr % 400 == 0){
            System.out.println(jahr + " ist ein Schaltjahr");
        } else {
            System.out.println(jahr + " ist kein Schaltjahr");
        }
    }
}

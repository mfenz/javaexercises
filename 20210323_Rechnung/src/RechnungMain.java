import java.util.Scanner;

public class RechnungMain {
    public static void main(String[] args) {
        Shop shop = new Shop();

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Was wollen Sie tun? (add, list, q)");
            String input = scanner.nextLine();
            switch (input){
                case "add": shop.addItem(); break;
                case "list": shop.listItems(); break;
                case "q": break;
            }
        }
    }
}

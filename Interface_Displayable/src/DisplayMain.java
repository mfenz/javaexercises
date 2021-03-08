import model.User;
import service.DisplayService;

public class DisplayMain {
    public static void main(String[] args) {
        User user = new User("ASDF", "Langer Text");
        DisplayService.display(user);
    }
}

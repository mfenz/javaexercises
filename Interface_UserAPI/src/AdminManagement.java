import model.User;
import service.UserService;

public class AdminManagement {
    // Unsere API
    private UserService userService;
    // Implementierung des userService wird hier übergeben
    public AdminManagement(UserService userService) {
        this.userService = userService;
    }
    public void createUser(String name){
        // service wird ID erstellen (deshalb null)
        User user = new User(null, name);
        // User speichern
        userService.save(user);
    }
}

package at.cb.iface.service;

public class UserVerwaltung {
    public static void main(String[] args) {
        UserService userService;
//        userService = new DatabaseUserService();
//        userService = new FileUserService();
        userService = new OracleDbUserService();

        if(true){
            userService = new FileUserService();
        }


        userService.createUser("jemand@email.com", "1234", "Jemand");
        User u = userService.getUserById(1);
    }
}

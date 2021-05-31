package at.cb.iface.service;

import java.util.List;

public interface UserService {
    void createUser(String email, String passwort, String vorname);
    List<User> getUsers();
    User getUserById(int id);
    void updateUser(User user);
}

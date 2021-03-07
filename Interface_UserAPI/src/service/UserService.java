package service;

import model.User;

import java.util.List;

public interface UserService {
    User getUserById(String id);
    void save(User user);
    int getUserCount();
    List<User> getUsers();
}

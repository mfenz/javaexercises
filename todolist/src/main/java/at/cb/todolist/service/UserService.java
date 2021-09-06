package at.cb.todolist.service;

import at.cb.todolist.formdata.RegistrationData;
import at.cb.todolist.model.User;
import at.cb.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;

    public User createUser(RegistrationData data) {
        // Passwort hashen!!
        String passwordHash = bCryptPasswordEncoder.encode(data.getPassword());

        // Objekt der Klasse mit Daten erstellt
        User user = new User(data.getEmail(), passwordHash, data.getName());

        // User in der Datenbank speichern
        user = userRepository.save(user);

        return user;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
}

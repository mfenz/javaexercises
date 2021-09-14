package at.cb.todolist.service;

import at.cb.todolist.formdata.RegistrationData;
import at.cb.todolist.model.Role;
import at.cb.todolist.model.User;
import at.cb.todolist.repository.RoleRepository;
import at.cb.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public User createUser(RegistrationData data) {
        // Passwort hashen!!
        String passwordHash = bCryptPasswordEncoder.encode(data.getPassword());

        // Alle neuen User mit der Rolle "USER" ausstatten
        Role userRole = getUserRole().get();
        List<Role> roles = List.of(userRole);

        // Objekt der Klasse mit Daten erstellt
        User user = new User(data.getEmail(), passwordHash, data.getName(), roles);

        // User in der Datenbank speichern
        user = userRepository.save(user);

        return user;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public Optional<Role> getUserRole(){
        return roleRepository.findById("USER");
    }
}

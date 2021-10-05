package at.cb.testingcms.service;

import at.cb.testingcms.formdata.RegistrationData;
import at.cb.testingcms.model.Role;
import at.cb.testingcms.model.User;
import at.cb.testingcms.repository.RoleRepository;
import at.cb.testingcms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleRepository roleRepository;

    /*public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }*/


    public User register(RegistrationData data){
        checkEmail(data.getEmail());
        checkPassword(data.getPassword());

        // E-Mail als Kleinbuchstaben speichern
        String email = data.getEmail().toLowerCase();

        // Passwort als bcrypt hash
        String passwordHash = bCryptPasswordEncoder.encode(data.getPassword());

        // Neue User haben die Rolle USER
        Role roleUser = roleRepository.getById("USER");
        List<Role> roles = List.of(roleUser);

        User user = new User(email, passwordHash, data.getName(), roles);

        user = userRepository.save(user);

        return user;
    }

    private void checkEmail(String email){
        // E-Mail prüfen
        if(email == null || email.isBlank() || !email.contains("@")){
            throw new ServiceException("E-Mail eingeben");
        }
        // Gibt es bereits User mit dieser E-Mail?
        if(userRepository.findByEmail(email).isPresent()){
            throw new ServiceException("E-Mail Adresse bereits verwendet");
        }
    }

    private void checkPassword(String password){
        if(password == null || password.length() < 8){
            throw new ServiceException("Passwort muss aus mindestens 8 Zeichen bestehen");
        }
        // Enthält das Passwort mindestens eine Zahl?
        if(!password.matches(".*\\d.*")){
            throw new ServiceException("Passwort muss mindestens eine Zahl enthalten");
        }
    }

    public List<User> getUsers(){
        return userRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(User::getName))
                .collect(Collectors.toList());
    }

    public User getUser(int id){
        return userRepository.findById(id).get();
    }

}

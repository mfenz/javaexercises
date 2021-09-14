package at.cb.cms.service;

import at.cb.cms.formdata.RegistrationData;
import at.cb.cms.model.Role;
import at.cb.cms.model.User;
import at.cb.cms.repository.RoleRepository;
import at.cb.cms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User createAccount(RegistrationData registrationData){
        // 1) Passwort hashen
        String pwHash = passwordEncoder.encode(registrationData.getPassword());

        List<Role> roles = new ArrayList<>();
        // Default-Roles für neue User aus der DB holen
        roles.add(roleRepository.getById("USER"));

        User user = new User(registrationData.getName(), registrationData.getEmail(), pwHash, roles);

        user = userRepository.save(user);

        return user;
    }
}

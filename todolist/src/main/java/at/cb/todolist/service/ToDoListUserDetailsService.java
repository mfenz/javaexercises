package at.cb.todolist.service;

import at.cb.todolist.model.User;
import at.cb.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToDoListUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     * User anhand des eingegebenen Usernames (hier E-Mail) laden und zurückgeben
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(
            String username) throws UsernameNotFoundException {
        // User anhand "username" in der DB suchen

        Optional<User> optionalUser = userRepository.findByEmail(username);
        // Gibt es KEINEN User mit der eingegebenen E-Mail Adresse?
        if(optionalUser.isEmpty()){
            // hier immer UsernameNotFoundException verwenden!!!
            throw new UsernameNotFoundException(username);
        }

        User user = optionalUser.get();

        // User-Roles in List von GrantedAuthorities umwandeln
        List<SimpleGrantedAuthority> roles = user
                .getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toList());

        // org.springframework.security.core.userdetails.User
        org.springframework.security.core.userdetails.User springSecurityUser =
                new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()), user.getPassword(), roles);

        // Spring "erklären" wer sich gerade anmelden wollte
        return springSecurityUser;
    }
}

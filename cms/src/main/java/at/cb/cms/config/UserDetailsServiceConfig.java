package at.cb.cms.config;

import at.cb.cms.model.User;
import at.cb.cms.repository.UserRepository;
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
public class UserDetailsServiceConfig implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     *
     * @param username ist der beim Login-Formular eingegebene Username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(
            String username) throws UsernameNotFoundException {
        // User anhand von "username" aus der Datenbank laden
        Optional<User> optionalUser = userRepository.findByEmail(username);

        // Gibt es KEINEN User mit der angegebenen Email (Username)?
        // --> throw new UsernameNotFoundException()
        if(optionalUser.isEmpty()){
            throw new UsernameNotFoundException(username);
        }

        // Gibt es den User?
        // --> Rollen laden
        User user = optionalUser.get();
        // Role in -> SimpleGrantedAuthority umwandeln
        // List<Role> --> List<SimpleGrantedAuthority>
        List<SimpleGrantedAuthority> roles = user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toList());

        // User zurückgeben (Passwort prüfen macht Spring im Hintergrund!)

        org.springframework.security.core.userdetails.User springSecurityUser =
                new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()), user.getPassword(), roles);
        return springSecurityUser;
    }
}

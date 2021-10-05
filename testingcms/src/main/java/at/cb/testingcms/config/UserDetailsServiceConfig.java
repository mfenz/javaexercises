package at.cb.testingcms.config;

import at.cb.testingcms.model.User;
import at.cb.testingcms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceConfig implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Gibt es den User?
        User user = userRepository
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        // Welche Rollen hat der User?
        // Rollen in SimpleGrantedAuthority umwandeln
        List<SimpleGrantedAuthority> roles = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                String.valueOf(user.getId()), user.getPassword(), roles);
    }
}


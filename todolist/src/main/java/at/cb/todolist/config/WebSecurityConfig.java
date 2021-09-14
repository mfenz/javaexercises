package at.cb.todolist.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 1) /tasks beginnt --> angemeldet und "USER" Rolle
         * 2) /admin beginnt --> angemeldet und "ADMIN" Rolle
         * 3) /logout --> angemeldet
         * 4) /login --> nicht angemeldet
         */
        http.authorizeRequests()
                .antMatchers("/tasks", "/tasks/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/admin", "/admin/**").hasAnyRole("ADMIN")
                .and()
                .formLogin() // Wie soll die Authentifizierung stattfinden?
                .defaultSuccessUrl("/?loggedin=true") // welche Seite soll nach dem Login aufgerufen werden?
                .and()
                .logout(); // Logout-Formular aktivieren


        // Alle Requests zulassen
//        http
//                //.csrf().disable()
//                .authorizeRequests()
//                .anyRequest()
//                .permitAll();
    }
}

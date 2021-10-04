package at.cb.testingcms.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // alles was mit /admin beginnt, darf nur mit der Rolle ADMIN aufgerufen werden
                .antMatchers("/admin/**", "/admin").hasRole("ADMIN")
                // alle anderen Seiten dürfen von allen aufgerufen werden
                .anyRequest().permitAll()
                // Login aktivieren
                .and()
                .formLogin()
                // Logout aktivieren
                .and()
                .logout();
                // Remember me (Optional zum Angemeldet bleiben)
                //.and()
                //.rememberMe();
    }
}

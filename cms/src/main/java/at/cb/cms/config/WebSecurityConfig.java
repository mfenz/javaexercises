package at.cb.cms.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Welche Bereiche der Anwendung werden geschützt?

        //http.authorizeRequests().antMatchers()
        // --> alle Zugriffe zulassen (ohne Login)
        http.authorizeRequests().anyRequest().permitAll();
    }
}

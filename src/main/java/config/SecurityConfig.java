package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

import service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private UserDetailsService userService;

    public SecurityConfig() {
    }

    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.userDetailsService(userService);

        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/webjars/**", "/resources/**", "/css/**").permitAll()
                .requestMatchers("/").permitAll()
                .anyRequest().authenticated());

        http.formLogin((form) -> form.permitAll());
        http.logout((logout) -> logout.permitAll());

        return http.build();

    }

}

package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public SecurityConfig() {
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.userDetailsService(null); // que pija va aca? en ves de null

        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/webjars/**", "/resources/**", "/css/**").permitAll()
                .requestMatchers("/").permitAll()
                .anyRequest().authenticated());

        http.formLogin((form) -> form.permitAll());
        http.logout((logout) -> logout.permitAll());

        return http.build();

    }

}

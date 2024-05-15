package sia.tacocoud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(request -> request
                        .requestMatchers("/design/**", "/order/**").hasRole("USER")
                        .anyRequest().permitAll())
                .formLogin(login -> login.loginPage("/login").permitAll().defaultSuccessUrl("/design"))
                .logout(logout -> logout.logoutUrl("/logout").permitAll().logoutSuccessUrl("/login"))
                .httpBasic(Customizer.withDefaults())
                .build();
    }




}




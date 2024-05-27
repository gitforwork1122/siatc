package sia.tacocoud.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = false, jsr250Enabled = true)
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    // In memory authentication
    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder encoder) {
        UserDetails user = User.builder()
                .username("user")
                .password(encoder.encode("password"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }


    //    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http.authorizeHttpRequests(request -> request
//                        .requestMatchers("/design/**", "/order/**").hasRole("USER")
//                        .requestMatchers("/design/**", "/order/**").hasRole("USER")
//                        .anyRequest().permitAll())
//                .formLogin(login -> login.loginPage("/login").permitAll().defaultSuccessUrl("/design"))
//                .logout(logout -> logout.logoutUrl("/logout").permitAll().logoutSuccessUrl("/login"))
//                .httpBasic(Customizer.withDefaults())
//                .build();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http.authorizeHttpRequests(authz -> authz
//                        .requestMatchers(HttpMethod.POST, "api/ingredients").hasAuthority("SCOPE_deleteIngredients")
//                        .requestMatchers(HttpMethod.POST, "api/ingredients").hasAuthority("SCOPE_deleteIngredients"))
//                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults())).build();
//    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/**").permitAll()
                        .anyRequest()
                )
                .formLogin(login -> login.loginPage("/login").permitAll().defaultSuccessUrl("/design"))
                .logout(logout -> logout.logoutUrl("/logout").permitAll().logoutSuccessUrl("/login"))
                .httpBasic(Customizer.withDefaults())
                .build();


    }


}
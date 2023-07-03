package ru.netology.hibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .logout((logout) -> logout.permitAll());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        List<UserDetails> users = List.of(
                User
                        .withUsername("user_read")
                        .password("{noop}password")
                        .roles("READ")
                        .build(),
                User
                        .withUsername("user_write")
                        .password("{noop}password")
                        .roles("WRITE")
                        .build(),
                User
                        .withUsername("user_delete")
                        .password("{noop}password")
                        .roles("DELETE")
                        .build(),
                User
                        .withUsername("Vasya")
                        .password("{noop}password")
                        .roles("READ")
                        .build());

        return new InMemoryUserDetailsManager(users);
    }
}
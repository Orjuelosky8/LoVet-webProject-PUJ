package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @SuppressWarnings("removal")
    protected void configure(HttpSecurity http) throws Exception {
        http.headers(headers -> headers
                .frameOptions().sameOrigin()); // Permitir que se muestre en marcos del mismo dominio

        http.headers(headers -> headers
                .frameOptions().disable())
                .headers(headers -> headers
                        .addHeaderWriter(new StaticHeadersWriter("Content-Security-Policy", "frame-ancestors http://localhost:8090/h2/*;")));
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http    
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(authz -> authz
                        .requestMatchers("/**").permitAll()
                        // .requestMatchers("/Servicios", "/Personal").hasAuthority("ROLE_CLIENTE")
                        // .requestMatchers("/clientes/**", "/mascotas/**").hasAuthority("ROLE_VETERINARIO")
                        // .requestMatchers("/veterinarios/**").hasAuthority("ROLE_ADMIN")
                        .anyRequest().authenticated()
                        )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/", true)
                        .permitAll())
                .logout(logout -> logout.permitAll());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
    // @Bean
    // public PasswordEncoder passwordEncoder() {
    // return new BCryptPasswordEncoder();
    // }


    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder()) 
                .and()
                .build();
    }

    // @Bean
    // public AuthenticationManager authManager(HttpSecurity http) throws Exception
    // {
    // return http.getSharedObject(AuthenticationManagerBuilder.class)
    // .userDetailsService(userDetailsService)
    // .passwordEncoder(passwordEncoder())
    // .and()
    // .build();
    // }
}

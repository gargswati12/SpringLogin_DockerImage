package com.swati.springsecuritydemotutorial.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        http
        .csrf(csrf -> csrf.disable())
        .httpBasic(Customizer.withDefaults())
        .authorizeHttpRequests((auth -> auth
        .requestMatchers("/","/register/**", "/css/**").permitAll()
        .requestMatchers("/admin/**").hasRole("ADMIN")
        .requestMatchers("/user/**").hasRole("USER")
        .anyRequest().authenticated()))
        .formLogin(form -> form
        .loginPage("/login")
        .successHandler(new MyAuthenticationSuccessHandler())
        .failureUrl ("/login?error=true")
        .permitAll())
        .logout(logout -> logout.logoutSuccessUrl("/login?logout")
        .permitAll());
        return http.build();
    }
    
}

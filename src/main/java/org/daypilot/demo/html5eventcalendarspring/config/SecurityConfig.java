package org.daypilot.demo.html5eventcalendarspring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.Authentication;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
        .authorizeRequests(auth -> auth.anyRequest().permitAll());
    return http.build();

    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    //     http.headers(headers -> headers
    //             .frameOptions().sameOrigin()
    //             .httpStrictTransportSecurity().disable());
    //     http.
    //             csrf(csrf -> csrf.disable()).
    //             sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).
    //             authorizeHttpRequests(auth -> auth.anyRequest().permitAll()).
    //             exceptionHandling(handling -> handling.authenticationEntryPoint(unauthorizedEntryPoint()));

    //     return http.build();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationEntryPoint unauthorizedEntryPoint() {
        return (request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }

}


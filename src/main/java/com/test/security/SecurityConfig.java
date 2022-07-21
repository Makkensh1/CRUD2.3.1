package com.test.security;

import com.test.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@EnableWebSecurity
@Slf4j
public class SecurityConfig {

    private  UserService userService;
    @Autowired
    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/login", "/")
                .permitAll()
                .antMatchers("/catalog", "/profile").hasAnyRole("ROLE_USER",  "ROLE_MANAGER", "ROLE_ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .build();
    }


    public void authWithHttpServletRequest(HttpServletRequest request, String username, String password) {
        try {
            request.login(username, password);
        } catch (ServletException e) {
            log.error("Error while login ", e);
        }
    }
}

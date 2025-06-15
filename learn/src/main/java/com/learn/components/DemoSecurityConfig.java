package com.learn.components;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) {
        try {
            http.authorizeHttpRequests(configurer -> configurer.
                            requestMatchers(HttpMethod.GET, "/managers").hasRole("MANAGER").
                            requestMatchers(HttpMethod.GET, "/").hasAnyRole("MANAGER", "EMPLOYEE", "ADMIN").
                            anyRequest().authenticated()
                    ).formLogin(form ->
                            form.loginPage("/login").
                                    loginProcessingUrl("/authenticateTheUser").permitAll()
                    ).logout(LogoutConfigurer::permitAll)
                    .exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied"));

            http.csrf(AbstractHttpConfigurer::disable);

            http.httpBasic(Customizer.withDefaults());

            return http.build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource source) {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(source);
        manager.setUsersByUsernameQuery(
                "select user_name,password,active from members where user_name = ?");
        manager.setAuthoritiesByUsernameQuery(
                "select user_name,role from roles where user_name = ?");
        return manager;
    }
}
package com.minjun.springfinal.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@ComponentScan(basePackages = {"com.minjun.springfinal.security"})
public class SecurityConfig {

    /**
     * 패스워드 인코더를 설정합니다.
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder
                = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);

        httpSecurity
                .csrf().disable()
                        .formLogin();


        httpSecurity.authenticationManager(authenticationManagerBuilder.build());

        httpSecurity.authorizeRequests()
                .antMatchers("/secu/all").permitAll();

        httpSecurity.authorizeRequests()
                .antMatchers("/secu/auth").hasRole("USER");


        return httpSecurity.build();
    }
}

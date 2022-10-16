package com.minjun.springfinal.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 해당 애노테이션을 붙히면 스프링 시큐리티 필터가
 * 스프링 필터체인에 자동으로 등록된다.
 *
 * extends WebSecurityConfigurerAdapter는 Deprecated됨!
 */
@EnableWebSecurity
@ComponentScan(basePackages = {"com.minjun.springfinal.security"})
public class SecurityConfig {

    /**
     * 패스워드 인코더를 설정합니다.
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder
                = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);


        httpSecurity.authenticationManager(authenticationManagerBuilder.build());

        httpSecurity
                .csrf().disable();

        /**
         * Expression-Based Access Control
         *
         * ANT Style : ?: 한 문자 매칭, *: 이후에 모든 문자 매칭, **: 패스까지 포함한 매칭
         *
         * hasRole은 권한을 검사할 때 ROLE_ 붙혀서 그 권한이 있는지 체크한다.
         *
         * https://docs.spring.io/spring-security/reference/servlet/authorization/expression-based.html
         *
         * 2022-10-16 04:09:48 DEBUG [org.springframework.security.web.context.SecurityContextPersistenceFilter] Set SecurityContextHolder to empty SecurityContext
         * 2022-10-16 04:09:48 DEBUG [org.springframework.security.web.context.HttpSessionSecurityContextRepository] Did not store empty SecurityContext
         * 2022-10-16 04:09:48 DEBUG [org.springframework.security.web.context.HttpSessionSecurityContextRepository] Did not store empty SecurityContext
         * 2022-10-16 04:09:48 DEBUG [org.springframework.security.web.context.SecurityContextPersistenceFilter] Cleared SecurityContextHolder to complete request
         *
         * TODO : Authority와 Role의 차이는?
         */
        httpSecurity.authorizeRequests()
//                .anyRequest().permitAll()
                .antMatchers("/denytest").denyAll()
                /**
                 * 익명이 아닌 사용자로 인증된 경우 접근을 허용한다.
                 */
                .antMatchers("/user/**").authenticated()
                /**
                 * 인자로 전달된 SpEL 표현식이 true면 접근을 허용한다.
                 * access이 웹 요청 ACL 스프링 표현식이다.
                 */
//                .antMatchers("roleTest").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
                .antMatchers("/board/**").hasAnyAuthority("ROLE_USER")
                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                /**
                 * anyRequest.permitAll은 하단에다가 해야한다.
                 */
                .anyRequest().permitAll()

                .and()
                /**
                 * formLogin만 쓰면 기본 로그인 페이지를 호출한다.
                 */
                .formLogin()
                /**
                 * 로그인 페이지는 아래 경로로 접근한다.
                 */
                .loginPage("/auth/login")
                /**
                 * 로그인에 성공하면 아래 url을 호출한다.
                 * 두번째 파라메터가 true이면 로그인 전 어떤 페이지와 무관하게
                 * 아래 페이지로 이동한다.
                 */
                .defaultSuccessUrl("/user")
                .and()
                .logout()
                /**
                 * 로그아웃 하면 메인으로 이동한다.
                 */
                .logoutSuccessUrl("/");


        return httpSecurity.build();
    }
}

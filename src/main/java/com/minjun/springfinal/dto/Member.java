package com.minjun.springfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
/**
 * 스프링 시큐리티에서 사용할 유저 객체를 정의한다.
 * org.springframework.security.core.userdetails.UserDetails 인터페이스를 상속 받고,
 * 아래의 모든 메소드들을 오버라이드 한다.
 */
public class Member implements UserDetails {

    private Long userId;
    private String username;
    private String password;
    private String name;
    private LocalDateTime createdDt;
    private LocalDateTime deletedDt;
    private boolean disabled;
    private List<String> roles;


    /**
     * 권한 목록을 가져온다.
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map((roleName) ->
                        /**
                         * GrantedAuthority 를 구현한 SimpleGrantedAuthority를 사용한다.
                         *
                         */
                new SimpleGrantedAuthority("ROLE_" + roleName))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * 계정이 만료가 되지 않았는지?
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    /**
     * 계정이 잠기지 않았는가?
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    /**
     * 계정이 사용 가능한가?
     * @return
     */
    @Override
    public boolean isEnabled() {
        return !this.disabled;
    }
}

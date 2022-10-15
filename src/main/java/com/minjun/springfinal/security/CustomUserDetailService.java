package com.minjun.springfinal.security;

import com.minjun.springfinal.mapper.MemberMapper;
import com.minjun.springfinal.dto.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {


    /**
     * 스프링 시큐리티는 username을 이용하여 먼저 DB에 있는 회원정보를 불러옵니다.
     * 불러온 이후, 객체에 있는 정보를 가지고 비교합니다.
     */
    private final PasswordEncoder passwordEncoder;
    private final MemberMapper memberMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberMapper.findByUsername(username).get();
    }
}

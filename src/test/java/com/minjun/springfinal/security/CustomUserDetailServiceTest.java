package com.minjun.springfinal.security;

import com.minjun.springfinal.config.RootConfig;
import com.minjun.springfinal.dto.Member;
import com.minjun.springfinal.mapper.MemberMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(RootConfig.class)
class CustomUserDetailServiceTest {

    PasswordEncoder passwordEncoder;

    @Autowired(required = false)
    MemberMapper memberMapper;

    @BeforeEach
    void setUp() {
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @Test
    /**
     * 테스트 케이스에서 트랜잭션 애노테이션을 붙히면
     * 성공에 대한 여부는 확인이 가능하지만, rollback 처리를 한다.
     * TODO : Auto Increment?
     */
    @Transactional
    void registerUser() {
        Member member = Member.builder()
                .username("testuser")
                .password(passwordEncoder.encode("1234"))
                .name("테스트 계정")
                .build();
        memberMapper.insertMember(member);


    }
}
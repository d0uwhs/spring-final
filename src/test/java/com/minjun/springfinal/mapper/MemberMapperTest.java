package com.minjun.springfinal.mapper;

import com.minjun.springfinal.config.RootConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(RootConfig.class)
class MemberMapperTest {

    @Autowired(required = false)
    MemberMapper memberMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void findByUsername() {
    }

    @Test
    void insertMember() {
    }

    @Test
    void insertRoles() {
    }
}
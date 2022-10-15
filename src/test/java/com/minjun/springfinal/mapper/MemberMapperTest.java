package com.minjun.springfinal.mapper;

import com.minjun.springfinal.config.RootConfig;
import com.minjun.springfinal.dto.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;
import java.util.stream.IntStream;

@SpringJUnitConfig(RootConfig.class)
class MemberMapperTest {

    @Autowired(required = false)
    MemberMapper memberMapper;

    // @Autowired // TODO : 주입을 받을 수 없는 이유는?
    PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        passwordEncoder = new BCryptPasswordEncoder();
    }

    //    @Test
//    void findByUsername() {
//    }

    @Test
    @DisplayName(value = "테스트 계정 생성")
    void insertMember() {
        String username = "user";
        String password = "1234";
        String name = "테스트계정";
        /**
         * 계정을 생성합니다.
         */
        IntStream.rangeClosed(1, 100).forEach((i) -> {
            Member member = Member.builder()
                    .userId((long) i)
                    .username(username + i)
                    /**
                     * 해싱한 비밀번호를 넣습니다.
                     */
                    .password(passwordEncoder.encode(password))
                    .name(name)
                    .build();

            /**
             * 권한을 랜덤하게 부여합니다.
             */
            if (i <= 60) {
                member.setRoles(List.of(1L));
            } else if (i <= 80) {
                member.setRoles(List.of(1L, 2L));
            } else {
                member.setRoles(List.of(1L, 2L, 3L));
            }
            /**
             * 계정을 등록합니다.
             */
            memberMapper.insertMember(member);
            /**
             * 멤버의 권한을 스트림을 이용하여
             * member_roles 테이블에 권한을 함께 등록합니다.
             */
            member.getRoles().forEach(roleNo -> {
                memberMapper.insertRoles(member.getUserId(), roleNo);
            });
        });
    }
}
package com.minjun.springfinal.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringJUnitConfig(RootConfig.class)
class RootConfigTest {

    @Autowired
    ApplicationContext applicationContext;


    @Test
    void sqlSessionFactory() {
        assertThat(applicationContext.getResource("classpath:/mybatis-config.xml")).isNotNull();
    }
}
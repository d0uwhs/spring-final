package com.minjun.springfinal.mapper;

import com.minjun.springfinal.config.RootConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringJUnitConfig(RootConfig.class)
class TestMapperTest {
    
    @Autowired(required = false)
    TestMapper testMapper;
    
    @Test
    void getTime() {
        assertThat(testMapper).isNotNull();
        log.info(testMapper.getTime());
    }
}
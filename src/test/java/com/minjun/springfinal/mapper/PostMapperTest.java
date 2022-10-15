package com.minjun.springfinal.mapper;

import com.minjun.springfinal.config.RootConfig;
import com.minjun.springfinal.dto.request.PostRequest;
import com.minjun.springfinal.dto.response.PostResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
@SpringJUnitConfig(RootConfig.class)
class PostMapperTest {

    @Autowired(required = false)
    PostMapper postMapper;

    @Test
    @DisplayName(value = "포스트 생성 테스트")
    void insertPost() {
        PostRequest postRequest = PostRequest.builder()
                .userId(1L)
                .postTitle("Test Post Title")
                .postBody("Test Post Body")
                .build();
        postMapper.insertPost(postRequest);
    }


    @Test
    @DisplayName("포스트 조회 테스트")
    void findById() {
        Long postNo = 1L;
        Optional<PostResponse> postResponseDTO = postMapper.findById(postNo);
        assertThat(postResponseDTO).isPresent();
    }
}
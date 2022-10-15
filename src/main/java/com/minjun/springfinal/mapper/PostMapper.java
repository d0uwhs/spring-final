package com.minjun.springfinal.mapper;

import com.minjun.springfinal.dto.request.PostRequest;
import com.minjun.springfinal.dto.response.PostResponse;

import java.util.Optional;

public interface PostMapper {
    Optional<PostResponse> findById(Long postNo);

    void insertPost(PostRequest postRequest);

}

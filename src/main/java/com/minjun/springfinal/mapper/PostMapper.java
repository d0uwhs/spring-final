package com.minjun.springfinal.mapper;

import com.minjun.springfinal.dto.request.PostRequestDTO;
import com.minjun.springfinal.dto.response.PostResponseDTO;

import java.util.Optional;

public interface PostMapper {
    Optional<PostResponseDTO> findById(Long postNo);

    void insertPost(PostRequestDTO postRequestDTO);

}

package com.minjun.springfinal.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private Long postNo;
    private Long userId;
    private String postTitle;
    private String postBody;
    private LocalDate createdDt;
    private LocalDate modifiedDt;
    private LocalDate deletedDt;
    private boolean disabled;
}

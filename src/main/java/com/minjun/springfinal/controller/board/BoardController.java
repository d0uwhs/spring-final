package com.minjun.springfinal.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 게시판 컨트롤러 입니다.
 * @author : 김민준
 */
@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("")
    public String list(){
        return "/board/list";
    }
}

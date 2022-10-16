package com.minjun.springfinal.controller.auth;


import com.minjun.springfinal.dto.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/auth/login")
public class LoginController {

    @GetMapping
    public void login(){
    }

    @PostMapping
    public void login(Member member){
        log.info(member.toString());
    }
}

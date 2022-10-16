package com.minjun.springfinal.controller.auth;


import com.minjun.springfinal.dto.Member;
import com.minjun.springfinal.dto.request.MemberRequest;
import com.minjun.springfinal.security.CustomUserDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/auth/register")
public class RegisterController {

    private final CustomUserDetailService customUserDetailService;

    @GetMapping
    public void register(){

    }

    /**
     * Member를 인자로 받고, 회원가입을 합니다.
     * @param memberRequest
     * @return
     */
    @PostMapping
    public String register(MemberRequest memberRequest){

//        customUserDetailService


        return "index";
    }
}

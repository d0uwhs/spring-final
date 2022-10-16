package com.minjun.springfinal;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * 이니셜라이저의 역할이 없더라도
 * 클래스 구현 안하면 시큐리티가 작동하지 않는다.
 */
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

}

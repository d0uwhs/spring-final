package com.minjun.springfinal.constants;

public enum Role {

    ROLE_ADMIN(1L, "ROLE_ADMIN"),

    ROLE_USER(2L, "ROLE_USER");
    private final Long roleNo;
    private final String roleName;

    Role(Long roleNo, String roleName) {
        this.roleNo = roleNo;
        this.roleName = roleName;
    }
}

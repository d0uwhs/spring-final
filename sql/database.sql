DROP DATABASE spring_practice;
CREATE DATABASE spring_practice;
USE spring_practice;

CREATE TABLE post
(
    post_no     BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id     BIGINT       NOT NULL,
    post_title  VARCHAR(255) NOT NULL,
    post_body   TEXT,
    created_dt  TIMESTAMP    NOT NULL DEFAULT NOW(),
    modified_dt TIMESTAMP    NOT NULL DEFAULT NOW(),
    deleted_dt  TIMESTAMP    NULL,
    disabled    BOOLEAN               DEFAULT FALSE
);

CREATE TABLE members
(
    user_id    BIGINT PRIMARY KEY AUTO_INCREMENT,
    username   VARCHAR(50)  NOT NULL,
    password   VARCHAR(255) NOT NULL,
    name       varchar(15)  NOT NULL,
    created_dt TIMESTAMP    NOT NULL DEFAULT NOW(),
    deleted_dt TIMESTAMP    NULL,
    disabled   BOOLEAN               DEFAULT FALSE
);

CREATE TABLE roles
(
    role_no   BIGINT PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(15) NOT NULL
);

CREATE TABLE members_roles
(
    user_id BIGINT NOT NULL,
    role_no BIGINT NOT NULL,
    CONSTRAINT members_roles_members_null_fk
        FOREIGN KEY (user_id) REFERENCES members (user_id),
    CONSTRAINT members_roles_roles_null_fk
        FOREIGN KEY (role_no) REFERENCES roles (role_no)
);


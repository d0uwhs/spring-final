package com.minjun.springfinal.mapper;

import com.minjun.springfinal.dto.Member;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface MemberMapper {
    Optional<Member> findByUsername(String username);

    void insertMember(Member member);

    /**
     * 마이바티스는 기본적으로 두개의 파라메터를 받지 않습니다.
     * 받게 하기 위해서는 @Param Annotation을 이용하여
     * 별칭을 지정해주면 사용할 수 있습니다.
     *
     * @param userId
     * @param roleNo
     */
    void insertRoles(
            @Param("userId") Long userId,
            @Param("roleNo") Long roleNo);
}

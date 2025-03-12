package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.app.domain.Member;

@Mapper
public interface MemberMapper {
    List<Member> selectMembers(
            @Param("address") String address,
            @Param("from") int from,
            @Param("to") int to);

    void addMember(Member member);
}

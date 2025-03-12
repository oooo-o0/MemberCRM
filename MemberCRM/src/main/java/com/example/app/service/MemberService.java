package com.example.app.service;

import java.util.List;

import com.example.app.domain.Member;

public interface MemberService {
    List<Member> searchAll();
    List<Member> searchByAddress(String address);
    List<Member> searchByAge(int from, int to);
    void save(Member member);
}

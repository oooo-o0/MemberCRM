package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.domain.Member;
import com.example.app.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberMapper memberMapper;

    @Override
    public List<Member> searchAll() {
        String address = "";
        int from = 0;
        int to = 999;
        return memberMapper.selectMembers(address, from, to);
    }

    @Override
    public List<Member> searchByAddress(String address) {
        int from = 0;
        int to = 999;
        return memberMapper.selectMembers(address, from, to);
    }

    @Override
    public List<Member> searchByAge(int from, int to) {
        String address = "";
        return memberMapper.selectMembers(address, from, to);
    }

    @Override
    public void save(Member member) {
        memberMapper.addMember(member);
    }
}

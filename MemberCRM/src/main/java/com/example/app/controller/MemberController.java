package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.domain.Member;
import com.example.app.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService service;

    @GetMapping
    public String all(Model model) {
        model.addAttribute("members", service.searchAll());
        return "members";
    }

    @GetMapping("/search")
    public String search(@RequestParam String address,
            @RequestParam int from, @RequestParam int to, @RequestParam(required = false) String addressButton,
            Model model) {
        if (addressButton != null) {
            if (address.isBlank()) {
                return "redirect:/members";
            }
            model.addAttribute("searchedBy", address);
            model.addAttribute("members", service.searchByAddress(address));
        } else {
            model.addAttribute("searchedBy", from + "歳〜" + to + "歳");
            model.addAttribute("members", service.searchByAge(from, to));
        }
        return "members";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Member member = new Member();
        member.setAge(20);
        model.addAttribute("member", member);
        return "addMember";
    }

    @PostMapping("/add")
    public String add(@Valid Member member, Errors errors) {
        if (errors.hasErrors()) {
            return "addMember";
        }
        service.save(member);
        return "redirect:/members";
    }
}

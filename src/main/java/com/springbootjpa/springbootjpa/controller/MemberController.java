package com.springbootjpa.springbootjpa.controller;

import com.springbootjpa.springbootjpa.domain.Address;
import com.springbootjpa.springbootjpa.domain.Member;
import com.springbootjpa.springbootjpa.domain.MemberDTO;
import com.springbootjpa.springbootjpa.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원 등록 페이지
     *
     * @param model Model attribute
     * @return 회원 등록 페이지
     */
    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberDTO", new MemberDTO());

        return "member/memberForm";
    }

    @PostMapping("/members/new")
    public String save(@Validated MemberDTO memberDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "member/memberForm";
        }
        Address address = new Address(memberDTO.getCity(), memberDTO.getStreet(), memberDTO.getZipcode());
        Member member = new Member();
        member.setName(memberDTO.getName()); // dto -> entity 변환 방법으로 변경 예정
        member.setAddress(address);

        memberService.save(member);

        return "redirect:/";

    }
}

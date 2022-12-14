package com.likelion.springbootboard.controller;

import com.likelion.springbootboard.domain.dto.MemberDto;
import com.likelion.springbootboard.domain.entity.Member;
import com.likelion.springbootboard.ser.MemberSer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/api/v1/member")
public class MemberController {
    private final MemberSer memberSer;

    public MemberController(MemberSer memberSer) {
        this.memberSer = memberSer;
    }

    @GetMapping("/join")
    public String joinPage(){
        return "join";
    }

    @PostMapping("/join")
    public String joinMember(MemberDto memberDto){
        memberSer.save(memberDto);
        return "login";
    }

    @PostMapping("/login")
    public String login(MemberDto memberDto, HttpSession httpSession) {
        MemberDto logResult = memberSer.login(memberDto);

        if (logResult!=null){
            //성공
            httpSession.setAttribute("id",logResult.getId());  //로그인한 회원 세션정보
            return "list";
        }else {
            //실패
            return "login";
        }
    }
}

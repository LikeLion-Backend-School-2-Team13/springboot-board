package com.likelion.springbootboard.ser;

import com.likelion.springbootboard.domain.dto.MemberDto;
import com.likelion.springbootboard.domain.entity.Member;
import com.likelion.springbootboard.repo.MemberRepo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class MemberSer {
    private final MemberRepo memberRepo;

    public MemberSer(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    //회원가입 정보 db저장
    public Member save(MemberDto memberDto){
        Member member = memberRepo.save(memberDto.toEntity());
        return member;
    }
    //로그인
    public MemberDto login(MemberDto memberDto) {
        Optional<Member> byId = memberRepo.findById(memberDto.getId());
        if (byId.isPresent()){
            //회원 있음
            Member member = byId.get();
            if(member.getPassword().equals(memberDto.getPassword())){ //패스워드 같은지 확인
                //패스워드 일치
                //entity -> dto
                MemberDto dto = MemberDto.toMemberDto(member);
                return dto;
            }else { //패스워드 불일치
                return null;
            }
        }else {
            //회원 없음
            return null;
        }
    }
    
    
}

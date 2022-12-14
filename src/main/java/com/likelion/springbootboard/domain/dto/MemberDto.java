package com.likelion.springbootboard.domain.dto;

import com.likelion.springbootboard.domain.entity.Member;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MemberDto {
    //사용자가 작성해서 전송하는 dto
    private String id;
    private String name;
    private String password;

    //dto -> entity
    public Member toEntity(){
        return Member.builder()
                .id(id)
                .name(name)
                .password(password)
                .build();
    }

//    entity -> dto
//    public static MemberDto toMemberDto(Member member){
//        return MemberDto.builder()
//                .id(id)
//                .name(name)
//                .password(password)
//                .build();

    public static MemberDto toMemberDto(Member member){
        MemberDto memberDto= new MemberDto();
        memberDto.setId(member.getId());
        memberDto.setName(memberDto.getName());
        memberDto.setPassword(memberDto.password);
        return memberDto;



    }

}

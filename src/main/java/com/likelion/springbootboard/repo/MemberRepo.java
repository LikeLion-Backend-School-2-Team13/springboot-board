package com.likelion.springbootboard.repo;

import com.likelion.springbootboard.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepo extends JpaRepository<Member,String> {
    //id로 회원조회  SELECT * FROM member WHERE member=?
    Optional<Member> findById(String id);
}

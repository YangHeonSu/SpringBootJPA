package com.springbootJpa.Repository;

import com.springbootJpa.Entity.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class) //Junit4의 Runwith과 같은 기능을 하는 Junit5 어노테이션
@SpringBootTest(classes = MemberRepository.class) // Junit5 기준 Application
@Transactional
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void test(){
        Member member = new Member();
        member.setUsername("memberA");

        Long memberId = memberRepository.save(member);
        Member memberInfo = memberRepository.findById(memberId);

        assertThat(memberInfo.getId()).isEqualTo(member.getId());
        assertThat(memberInfo.getUsername()).isEqualTo(member.getUsername());

    }
}
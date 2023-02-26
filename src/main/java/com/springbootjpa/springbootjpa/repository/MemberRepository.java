package com.springbootjpa.springbootjpa.repository;

import com.springbootjpa.springbootjpa.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 회원 저장
     *
     * @param member Member id, username
     * @return Long id
     */
    public Long save(Member member) {
        entityManager.persist(member); // 회원 저장 JPA
        return member.getId(); // 가급적 저장 후 Id를 반환
    }

    /**
     * Id(pk 값)으로 회원 정보 찾기
     *
     * @param id Long Id (= pk)
     * @return Member member
     */
    public Member findById(Long id) {
        return entityManager.find(Member.class, id);
    }
}

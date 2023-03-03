package myproject.myshop.repository;

import lombok.SneakyThrows;
import myproject.myshop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {
    //저장
    @PersistenceContext
    EntityManager em ;

    public String save(Member member){
        em.persist(member);
        return member.getUserId();
    }

    public Member findOne(String userId){
        Member member=em.find(Member.class,userId);
        return member;
    }
    public List<Member> findAll(){
        //findAll은 JPA가 지원하지 않는 기능이기 때문에 쿼리를 직접 만들어서 보내면 됨
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

}

package myproject.myshop;

import myproject.myshop.domain.Member;
import myproject.myshop.exception.DuplicationIdException;
import myproject.myshop.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
public class MemberServiceTest {
    @Autowired
    MemberService memberService;
    @PersistenceContext
    EntityManager em;

    @Test
    public void join(){
        //given
        Member member = new Member("testId1","password1" ,"test1");
        //when
        memberService.join(member);
        //then
        Member findMember = memberService.findOne(member.getUserId());
        Assertions.assertThat(member).isSameAs(findMember);
    }

    @Test
    public void Duplication_member(){
        //given
        Member member = new Member("testId2","password2" ,"test2");
        Member member2 = new Member("testId2","password2" ,"test2");
        //when
        memberService.join(member);

        //then
        Assertions.assertThatThrownBy(()->memberService.join(member2)).isInstanceOf(DuplicationIdException.class);

    }

}

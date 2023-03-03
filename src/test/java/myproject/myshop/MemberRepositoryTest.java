package myproject.myshop;

import myproject.myshop.domain.Address;
import myproject.myshop.domain.Email;
import myproject.myshop.domain.Member;
import myproject.myshop.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
@Rollback(value = false)
public class MemberRepositoryTest {
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;
    @BeforeEach
    public void init() {
        // TODO
    }
    @Test
    public void save(){
        //given
        Member member = new Member("testId1","password1" ,"test1");
        //when
        memberRepository.save(member);
        //then
        Member findMember = memberRepository.findOne(member.getUserId());
        Assertions.assertEquals(member.getUserId(),findMember.getUserId());

    }
    @Test
    public void AllDataSave(){
        //given
        Email email = new Email("testEmail2","naver.com");
        Address address= new Address("testAddress1","testStreet1","11111");

        Member member = new Member("testId2","password2","test2",
                "010-1111-1111",email,address);
        //when
        memberRepository.save(member);

        //then
        Member findMember = memberRepository.findOne(member.getUserId());
        Assertions.assertEquals(member.getUserId(),findMember.getUserId());
    }


}

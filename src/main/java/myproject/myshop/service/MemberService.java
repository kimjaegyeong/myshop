package myproject.myshop.service;

import lombok.RequiredArgsConstructor;
import myproject.myshop.domain.Member;
import myproject.myshop.exception.DuplicationIdException;
import myproject.myshop.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public String join(Member member){
        DuplicationMember(member.getUserId());

        String memberId = memberRepository.save(member);

        return memberId;
    }

    public Member findOne(String userId){
        Member member = memberRepository.findOne(userId);
        return member;
    }

    public List<Member> findAll(){
        List<Member> members = memberRepository.findAll();
        return members;
    }

    public void DuplicationMember(String userId){
        Member findMember = memberRepository.findOne(userId);
        if(!(findMember==null)){
            throw new DuplicationIdException("duplicate Member");
        }
    }

}

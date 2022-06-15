package service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*회원 가입*/
    public Long join(Member member) {

        validateDuplicateMember(member);//이름 중복 막기
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());
        //Member member1 = result.get();
        //result.orElseGet() 을 많이씀
        result.ifPresent(m -> {
            throw new IllegalStateException("이름 중복 입니다.");
        });
    }
    //전체 회원 조회
    public List<Member> findMembers(){
        return  memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
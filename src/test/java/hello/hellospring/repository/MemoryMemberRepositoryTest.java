package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("string");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        //4:40 syso로 보는법
        Assertions.assertEquals(member,result);
        Assertions.assertThat(member).isEqualTo(result);
        Assertions.
    }
}

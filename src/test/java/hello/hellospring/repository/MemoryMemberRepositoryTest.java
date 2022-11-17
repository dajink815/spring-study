package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * @author dajin kim
 */
class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // @AfterEach 를 사용하면 각 테스트가 종료될 때 마다 이 기능을 실행한다.
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("dajin");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        // import org.junit.jupiter.api.Assertions;
        // Assertions.assertEquals(result, member);

        // import org.assertj.core.api.Assertions;
        assertThat(member).isEqualTo(result);
        // option + F6 -> static 으로 import

        System.out.println(member.getId());
        System.out.println(member.getName());
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("dajin1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("dajin2");
        repository.save(member2);

        Member result = repository.findByName("dajin1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("dajin1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("dajin2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }


}

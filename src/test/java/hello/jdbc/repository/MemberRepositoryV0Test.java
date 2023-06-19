package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MemberRepositoryV0Test {

    MemberRepositoryV0 repository = new MemberRepositoryV0();
    @Test
    void crud() throws SQLException {
        //save
        Member member = new Member("memberV2", 10000);
        repository.save(member);

        //findById
        Member findMember = repository.findById(member.getMemberid());
        log.info("findMember={}", findMember);
        log.info("member != findMember {}", member == findMember);
        log.info("member != findMember {}", member.equals(findMember));

        assertThat(findMember).isEqualTo(member);

        //update : money: 10000 -> 20000
        repository.update(member.getMemberid(), 20000);
        Member updateMember = repository.findById(member.getMemberid());
        assertThat(updateMember.getMoney()).isEqualTo(20000);

        //delete
        repository.delete(member.getMemberid());
        assertThatThrownBy(() -> repository.findById(member.getMemberid())).isInstanceOf(NoSuchElementException.class);
    }
}
package hello.jdbc.service;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.SQLException;

import static hello.jdbc.connection.ConnectionConst.*;
import static org.assertj.core.api.Assertions.*;

/**
 *  기본 동작, 트랜잭션이 없어서 문제 발생
 */

class MemberServiceV1Test {


    public static final String MEMBER_A = "memberA";
    public static final String MEMBER_B = "memberB";
    public static final String MEMBER_EX = "ex";

    private MemberRepositoryV1 memberRepository;
    private MemberServiceV1 memberService;

    @BeforeEach
    void before(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
        memberRepository = new MemberRepositoryV1(dataSource);
        memberService = new MemberServiceV1(memberRepository);
    }

    @Test
    @DisplayName("정상 이체")
    void accountTransfer() throws SQLException {
        //given
        Member memberA = new Member(MEMBER_A, 10000);
        Member memberB = new Member(MEMBER_B, 10000);
        memberRepository.save(memberA);
        memberRepository.save(memberB);

        //when
        memberService.accountTransfer(memberA.getMemberid(), memberB.getMemberid(), 2000);

        //then
        Member findMemberA = memberRepository.findById(memberA.getMemberid());
        Member findMemberB = memberRepository.findById(memberB.getMemberid());
        assertThat(findMemberA.getMoney()).isEqualTo(8000);
        assertThat(findMemberB.getMoney()).isEqualTo(12000);

    }

    @Test
    @DisplayName("정상 이체 다른테스트")
    void accountTransfer1() throws SQLException {
        //given
        Member memberA = new Member(MEMBER_A, 10000);
        Member memberB = new Member(MEMBER_B, 10000);
        memberRepository.save(memberA);
        memberRepository.save(memberB);

        //when
        memberService.accountTransfer(memberA.getMemberid(), memberB.getMemberid(), 2000);

        //then
        Member findMemberA = memberRepository.findById(memberA.getMemberid());
        Member findMemberB = memberRepository.findById(memberB.getMemberid());
        assertThat(findMemberA.getMoney()).isEqualTo(8000);
        assertThat(findMemberB.getMoney()).isEqualTo(12000);

    }

    @Test
    @DisplayName("정상 이체 다른테스트1")
    void accountTransfer2() throws SQLException {
        //given
        Member memberA = new Member(MEMBER_A, 10000);
        Member memberB = new Member(MEMBER_B, 10000);
        memberRepository.save(memberA);
        memberRepository.save(memberB);

        //when
        memberService.accountTransfer(memberA.getMemberid(), memberB.getMemberid(), 2000);

        //then
        Member findMemberA = memberRepository.findById(memberA.getMemberid());
        Member findMemberB = memberRepository.findById(memberB.getMemberid());
        assertThat(findMemberA.getMoney()).isEqualTo(8000);
        assertThat(findMemberB.getMoney()).isEqualTo(12000);

    }

    @Test
    @DisplayName("정상 이체 다른테스트1")
    void accountTransfer3() throws SQLException {
        //given
        Member memberA = new Member(MEMBER_A, 10000);
        Member memberB = new Member(MEMBER_B, 10000);
        memberRepository.save(memberA);
        memberRepository.save(memberB);

        //when
        memberService.accountTransfer(memberA.getMemberid(), memberB.getMemberid(), 2000);

        //then
        Member findMemberA = memberRepository.findById(memberA.getMemberid());
        Member findMemberB = memberRepository.findById(memberB.getMemberid());
        assertThat(findMemberA.getMoney()).isEqualTo(8000);
        assertThat(findMemberB.getMoney()).isEqualTo(12000);

    }







    @Test
    @DisplayName("숫자 테스트111")
    void numberTest() throws SQLException {

        int displaySize = 36;

       if(displaySize < 36 || displaySize > 1000){
            System.out.println(" 비정상 = " + displaySize);
        }else{
            System.out.println(" 정상 = " + displaySize);
        }

    }


}
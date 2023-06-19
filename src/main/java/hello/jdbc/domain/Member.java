package hello.jdbc.domain;

import lombok.Data;

@Data
public class Member {

    private String memberid;
    private int money;

    public Member() {}

    public Member(String memberid, int money) {
        this.memberid = memberid;
        this.money = money;
    }
}

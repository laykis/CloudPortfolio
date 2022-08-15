package WK.Lab.Entity;

import javax.persistence.*;
import javax.sound.sampled.Port;

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UID")
    private Long uid;

    @Column(name = "ID")
    private String memberId;

    @Column(name = "PW")
    private String memberPw;

    @Column(name = "NAME")
    private String memberName;

    @Column(name = "PHONE")
    private String phoneNumber;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SEX")
    private String sex;

    @Column(name = "AGE")
    private String age;

    @Column(name = "GIT_TOKEN")
    private String gitToken;

    @Column(name = "DESCRIPTION")
    private String des;

    @OneToOne
    @JoinColumn(name = "MEMBER_PORTFOLIO_ID")
    private Portfolio memberPortfolio;

}

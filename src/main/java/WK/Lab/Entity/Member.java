package WK.Lab.Entity;

import lombok.Getter;

import javax.persistence.*;
import javax.sound.sampled.Port;

@Entity
@Getter
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

    public Member(){

    }

    public static class Builder{

        private String memberId;
        private String memberPw;
        private String memberName;
        private String phoneNumber;
        private String email;
        private String sex;
        private String age;
        private String gitToken;
        private String des;
        private Portfolio memberPortfolio;

        public Builder memberId(String memberId){
            this.memberId = memberId;
            return this;
        }

        public Builder memberPw(String memberPw){
            this.memberPw = memberPw;
            return this;
        }

        public Builder memberName(String memberName){
            this.memberName = memberName;
            return this;
        }

        public Builder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder sex(String sex){
            this.sex = sex;
            return this;
        }

        public Builder age(String age){
            this.age = age;
            return this;
        }

        public Builder gitToken(String gitToken){
            this.gitToken = gitToken;
            return this;
        }

        public Builder des(String des){
            this.des = des;
            return this;
        }

        public Builder memberPortfolio(Portfolio memberPortfolio){
            this.memberPortfolio = memberPortfolio;
            return this;
        }

        public Member build(){
            return new Member(this);
        }

    }

    public Member(Builder builder){
        this.memberId = builder.memberId;
        this.memberPw = builder.memberPw;
        this.memberName = builder.memberName;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
        this.sex = builder.sex;
        this.age = builder.age;
        this.gitToken = builder.gitToken;
        this.des = builder.des;
        this.memberPortfolio = builder.memberPortfolio;
    }

}

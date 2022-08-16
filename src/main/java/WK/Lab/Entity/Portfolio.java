package WK.Lab.Entity;

import lombok.Getter;
import org.springframework.security.core.parameters.P;

import javax.persistence.*;

@Entity
@Getter
public class Portfolio {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PID")
    private Long pid;

    @OneToOne(mappedBy = "memberPortfolio")
    private Member member;

    @OneToOne(mappedBy = "contentPortfolio")
    private Content content;

    public Portfolio(){

    }

    public static class Builder{
        private Member member;
        private Content content;

        public Builder member(Member member){
            this.member = member;
            return this;
        }

        public Builder content(Content content){
            this.content = content;
            return this;
        }

        public Portfolio build(){
            return new Portfolio(this);
        }
    }

    public Portfolio(Builder builder){
        this.member = builder.member;
        this.content = builder.content;
    }
}

package WK.Lab.Entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Content {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CID")
    private Long cid;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "TAG")
    private String tag;

    @OneToOne
    @JoinColumn(name = "CONTENT_PORTFOLIO_ID")
    private Portfolio contentPortfolio;

    public Content(){

    }

    public static class Builder{
        private String title;
        private String content;
        private String tag;
        private Portfolio contentPortfolio;

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder content(String content){
            this.content = content;
            return this;
        }

        public Builder tag(String tag){
            this.tag = tag;
            return this;
        }

        public Builder contentPortfolio(Portfolio contentPortfolio){
            this.contentPortfolio = contentPortfolio;
            return this;
        }

        public Content build(){
            return new Content(this);
        }
    }

    public Content(Builder builder){
        this.title = builder.title;
        this.content = builder.content;
        this.tag = builder.tag;
        this.contentPortfolio = builder.contentPortfolio;
    }
}

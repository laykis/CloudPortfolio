package WK.Lab.Entity;

import WK.Lab.DTO.ContentDTO;
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

    public ContentDTO convert(Content content){
        ContentDTO contentDTO = new ContentDTO();

        contentDTO.setCid(content.getCid());
        contentDTO.setTitle(content.getTitle());
        contentDTO.setContent(content.getContent());
        contentDTO.setTag(content.getTag());
        contentDTO.setContentPortfolio(content.getContentPortfolio());

        return contentDTO;

    }

    public void updateContent(ContentDTO contentDTO){
        this.title = contentDTO.getTitle();
        this.content = contentDTO.getContent();
        this.tag = contentDTO.getTag();
        this.contentPortfolio = contentDTO.getContentPortfolio();
    }
}

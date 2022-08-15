package WK.Lab.Entity;

import javax.persistence.*;

@Entity
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
}

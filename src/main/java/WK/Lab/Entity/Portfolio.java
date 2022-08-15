package WK.Lab.Entity;

import javax.persistence.*;

@Entity
public class Portfolio {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PID")
    private Long pid;

    @OneToOne(mappedBy = "memberPortfolio")
    private Member member;

    @OneToOne(mappedBy = "contentPortfolio")
    private Content content;
}

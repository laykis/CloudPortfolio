package WK.Lab.DTO;

import WK.Lab.Entity.Portfolio;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ContentDTO {

    private Long cid;
    private String title;
    private String content;
    private String tag;
    private Portfolio contentPortfolio;
}

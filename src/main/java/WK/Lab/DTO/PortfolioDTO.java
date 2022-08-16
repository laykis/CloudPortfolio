package WK.Lab.DTO;

import WK.Lab.Entity.Content;
import WK.Lab.Entity.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PortfolioDTO {

    private Long pid;
    private Member member;
    private Content content;
}

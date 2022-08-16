package WK.Lab.DTO;

import WK.Lab.Entity.Portfolio;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {

    private Long uid;
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
}

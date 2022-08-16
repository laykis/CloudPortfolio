package WK.Lab.Service;

import WK.Lab.DTO.ContentDTO;
import WK.Lab.Entity.Content;
import WK.Lab.Entity.Portfolio;
import WK.Lab.Repository.ContentRepository;
import WK.Lab.Repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;
    private final PortfolioRepository portfolioRepository;

    public ContentDTO viewContent(Long uid){

        //세션에 저장된 uid로 포트폴리오 아이디인 pid 조회
        Portfolio portfolio = portfolioRepository.findByMember_Uid(uid);

        //조회한 pid로 포트폴리오 content 조회
        Content content = contentRepository.findByContentPortfolio_Pid(portfolio.getPid());

        //엔티티 -> DTO 메소드인 convert로 DTO에 값 세팅
        ContentDTO contentDTO = content.convert(content);

        return contentDTO;
    }


}

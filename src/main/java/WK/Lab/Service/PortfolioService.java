package WK.Lab.Service;

import WK.Lab.DTO.ContentDTO;
import WK.Lab.Entity.Content;
import WK.Lab.Entity.Portfolio;
import WK.Lab.Repository.ContentRepository;
import WK.Lab.Repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final ContentRepository contentRepository;
    private final PortfolioRepository portfolioRepository;

    //개인 포트폴리오 불러오기
    public ContentDTO viewPortfolio(Long uid){

        //세션에 저장된 uid로 포트폴리오 아이디인 pid 조회
        Portfolio portfolio = portfolioRepository.findByMember_Uid(uid);

        //조회한 pid로 포트폴리오 content 조회
        Content content = contentRepository.findByContentPortfolio_Pid(portfolio.getPid());

        //엔티티 -> DTO 메소드인 convert로 DTO에 값 세팅
        ContentDTO contentDTO = content.convert(content);

        return contentDTO;
    }


    public void savePortfolio(ContentDTO contentDTO, Long uid){

        Portfolio portfolio = portfolioRepository.findByMember_Uid(uid);

        Content content = new Content.Builder()
                .title(contentDTO.getTitle())
                .content(contentDTO.getContent())
                .tag(contentDTO.getTag())
                .contentPortfolio(portfolio)
                .build();
    }

    //포트폴리오 수정 메소드
    public void updatePortfolio(ContentDTO contentDTO, Long uid){

        //세션에 저장된 uid로 포트폴리오 아이디 pid 조회
        Portfolio portfolio = portfolioRepository.findByMember_Uid(uid);

        //조회한 pid로 포트폴리오 content 조회
        Content content = contentRepository.findByContentPortfolio_Pid(portfolio.getPid());

        //수정 값 세팅 메소드인 updateContent를 이용해 DTO -> 엔티티 값 세팅
        content.updateContent(contentDTO);

    }





}
